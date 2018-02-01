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

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchFragment<B extends ViewDataBinding,VM extends ArchViewModel> extends Fragment implements IArchView<B,VM> {
    protected B mBinding;
    protected VM mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        executeInject();
        mViewModel = ViewModelProviders.of(this,new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());
        return mBinding.getRoot();
    }

}
