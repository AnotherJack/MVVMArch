package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.ViewDataBinding;

import io.github.anotherjack.mvvmarch.di.component.IComponent;

/**
 * Created by zhengj on 2018-2-1.
 */

public interface IArchView<B extends ViewDataBinding, VM extends ArchViewModel, C extends IComponent, DC extends IComponent> extends IView, LifecycleOwner {

    /**
     * 获取布局id
     *
     * @return
     */
    int getLayoutId();

    /**
     * 获取ViewModel的class类型
     *
     * @return
     */
    Class<? extends VM> getViewModelClazz();

    /**
     * 在此方法中执行Dagger inject
     */
    void executeInject(C component);

    /**
     * build此View对应的dagger component
     *
     * component = DaggerXXXX.build()
     * @return
     */
    void buildComponent(C mComponent, DC dependencyComponent);

    /**
     * 获取此View对应的dagger component
     * @return
     */
    C getComponent();

    /**
     * 获取此View依赖的component
     * activity依赖的为IAppComponent
     * activity中的fragment，依赖的为IActivityComponent
     * 嵌套在fragment中的fragment，依赖的为IFragmentComponent
     *
     * 此方法通常只需要在基类中实现即可
     * @return
     */
    DC getDependencyComponent();
}
