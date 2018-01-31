package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchActivity<B extends ViewDataBinding,VM extends IViewModel> extends AppCompatActivity implements IView,LifecycleOwner {
    protected B mBinding;
    private VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
    }

    protected abstract int getLayoutId();

}
