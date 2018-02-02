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

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.component.IActivityComponent;
import io.github.anotherjack.mvvmarch.di.component.IComponent;
import io.github.anotherjack.mvvmarch.di.component.IFragmentComponent;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchFragment<B extends ViewDataBinding,VM extends ArchViewModel,C extends IFragmentComponent, DC extends IComponent> extends Fragment implements IArchView<B,VM,C,DC> {
    protected B mBinding;
    @Inject
    protected VM mViewModel;

    private C mComponent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        buildComponent(mComponent,getDependencyComponent());
        executeInject(mComponent);
        mViewModel = ViewModelProviders.of(this,new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());
        return mBinding.getRoot();
    }

    @Override
    public DC getDependencyComponent() {
        DC dependencyComponent;
        Fragment parentFragment = getParentFragment();
        //parentFragment为null说明此fragment是添加在activity中的，反之说明此fragment是嵌套在parentFragment中的
        if(parentFragment == null){
            dependencyComponent = (DC) ((IArchView)getActivity()).getComponent();
        }else {
            dependencyComponent = (DC) ((IArchView)parentFragment).getComponent();
        }

        return dependencyComponent;
    }
}
