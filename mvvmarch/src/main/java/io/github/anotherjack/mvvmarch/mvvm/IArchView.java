package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.ViewDataBinding;

/**
 * Created by zhengj on 2018-2-1.
 */

public interface IArchView<B extends ViewDataBinding,VM extends ArchViewModel> extends IView,LifecycleOwner {

    /**
     * 获取布局id
     * @return
     */
    int getLayoutId();

    /**
     * 获取ViewModel的class类型
     * @return
     */
    Class<? extends VM> getViewModelClazz();

    /**
     * 在此方法中执行Dagger inject
     */
    void executeInject();
}
