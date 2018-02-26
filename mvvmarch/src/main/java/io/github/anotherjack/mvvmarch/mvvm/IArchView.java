package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.ViewDataBinding;


/**
 * Created by zhengj on 2018-2-1.
 */

//C为Component，DC为DependencyComponent
public interface IArchView<B extends ViewDataBinding, VM extends ArchViewModel, C> extends IView, LifecycleOwner {

    /**
     * 获取Activity或Fragment布局id
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
     * build此View对应的dagger component，并返回
     * 不要主动调用此方法，如果需要获得component，请使用getComponent
     * <p>
     * DaggerXXXX.build()
     *
     * @return
     */
    C buildComponent();

    /**
     * 在此方法中执行Dagger inject
     */
    void executeInject(C mComponent);

    /**
     * 获取此View对应的dagger component
     *
     * @return
     */
    C getComponent();

}
