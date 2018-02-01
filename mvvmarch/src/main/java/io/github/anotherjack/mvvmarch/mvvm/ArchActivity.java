package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchActivity<B extends ViewDataBinding,VM extends ArchViewModel> extends AppCompatActivity implements IArchView<B,VM> {
    protected B mBinding;
    @Inject
    private VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        executeInject();
        mViewModel = ViewModelProviders.of(this,new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());
    }


}
