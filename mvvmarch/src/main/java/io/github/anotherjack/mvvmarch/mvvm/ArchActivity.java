package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;


/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchActivity<B extends ViewDataBinding, VM extends ArchViewModel, C, DC> extends AppCompatActivity implements IArchView<B, VM, C, DC> {
    protected B mBinding;
    @Inject
    protected VM mViewModel;

    /**
     * 在子类的buildComponent方法中实例化
     */
    protected C mComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data binding
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());

        //build dagger component
        mComponent = buildComponent(getDependencyComponent());

        //用mComponent执行inject操作
        executeInject(mComponent); //此方法执行后mViewModel已经有值，但此时只是简单地通过构造器注入的，下面的代码会以标准的factory方式实现

        //获取mViewModel
        mViewModel = ViewModelProviders.of(this, new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());

        //为lifecycle添加observer，viewmodel已经实现了LifecycleObserver接口
        this.getLifecycle().addObserver(mViewModel);
    }

    @Override
    public C getComponent() {
        return mComponent;
    }

    @Override
    public Class<? extends VM> getViewModelClazz() {
        //注意！！默认通过反射获取ViewModel的class，如果对稳定性与性能有要求，请在子类中重写此方法，显示返回viewmodel的class
        return (Class<? extends VM>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
