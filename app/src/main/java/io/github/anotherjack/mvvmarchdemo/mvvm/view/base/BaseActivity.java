package io.github.anotherjack.mvvmarchdemo.mvvm.view.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.anotherjack.mvvmarch.mvvm.ArchActivity;
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel;
import io.github.anotherjack.mvvmarchdemo.app.MyApp;
import io.github.anotherjack.mvvmarchdemo.di.component.ActivityComponent;
import io.github.anotherjack.mvvmarchdemo.di.component.DaggerActivityComponent;
import io.github.anotherjack.mvvmarchdemo.di.module.ActivityModule;

/**
 * Created by jack on 2018/2/3.
 */

public abstract class BaseActivity<B extends ViewDataBinding, VM extends ArchViewModel, C> extends ArchActivity<B, VM, C, ActivityComponent> {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .appComponent(MyApp.getInstance().getAppComponent())
                .build();

        super.onCreate(savedInstanceState);

    }

    @Override
    public ActivityComponent getDependencyComponent() {
        return activityComponent;
    }
}
