package io.github.anotherjack.mvvmarchdemo.mvvm.view.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.anotherjack.mvvmarch.mvvm.ArchActivity;
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel;
import io.github.anotherjack.mvvmarchdemo.app.MyApp;
import io.github.anotherjack.mvvmarchdemo.di.component.AppComponent;
import io.github.anotherjack.mvvmarchdemo.di.module.CommonActivityModule;

/**
 * Created by jack on 2018/2/3.
 */

public abstract class BaseActivity<B extends ViewDataBinding, VM extends ArchViewModel, C> extends ArchActivity<B, VM, C> {
    private CommonActivityModule mCommonActivityModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mCommonActivityModule = new CommonActivityModule(this);

        super.onCreate(savedInstanceState);

    }

    @Override
    public final C buildComponent() {
        return buildComponent(MyApp.getInstance().getAppComponent(),mCommonActivityModule);
    }

    protected abstract C buildComponent(AppComponent appComponent, CommonActivityModule commonActivityModule);
}
