package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.component.IActivityComponent;
import io.github.anotherjack.mvvmarch.di.component.IAppComponent;
import io.github.anotherjack.mvvmarch.di.component.IComponent;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchActivity<B extends ViewDataBinding, VM extends ArchViewModel, C extends IActivityComponent, DC extends IAppComponent> extends AppCompatActivity implements IArchView<B, VM, C, DC> {
    protected B mBinding;
    @Inject
    private VM mViewModel;

    /**
     * 在子类的buildComponent方法中实例化
     */
    private C mComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        buildComponent(mComponent,getDependencyComponent());
        executeInject(mComponent); //此方法执行后mViewModel已经有值，但此时只是简单地通过构造器注入的，下面的代码会以标准的factory方式实现
        mViewModel = ViewModelProviders.of(this, new ViewModelInstanceFactory<VM>(mViewModel)).get(getViewModelClazz());
        this.getLifecycle().addObserver(mViewModel);
    }

    @Override
    public C getComponent() {
        return mComponent;
    }
}
