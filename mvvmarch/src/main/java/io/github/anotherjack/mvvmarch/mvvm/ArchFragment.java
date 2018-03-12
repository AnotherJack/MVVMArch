package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;


/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchFragment<B extends ViewDataBinding, VM extends ArchViewModel, C> extends Fragment implements IArchView<B, VM, C> {
    protected B mBinding;
    @Inject
    protected VM mViewModel;

    /**
     * 在子类的buildComponent方法中实例化
     */
    protected C mComponent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //data binding
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        //要使用livedata，需要设置lifecycle owner
        mBinding.setLifecycleOwner(this);

        //build dagger component
        mComponent = buildComponent();

        //用mComponent执行inject操作
        executeInject(mComponent);

        //获取mViewModel
        mViewModel = ViewModelProviders.of(this, new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());

        //为lifecycle添加observer，viewmodel已经实现了LifecycleObserver接口
        this.getLifecycle().addObserver(mViewModel);

        return mBinding.getRoot();
    }

    @Override
    public C getComponent() {
        return mComponent;
    }

    @Override
    public Class<? extends VM> getViewModelClazz() {
        //注意！！默认通过反射获取ViewModel的class，如果对稳定性与性能有要求，请在子类中重写此方法，返回viewmodel的class
        return (Class<? extends VM>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
