package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.ViewDataBinding;

/**
 * Created by zhengj on 2018-2-1.
 */

public interface IArchView<B extends ViewDataBinding,VM extends ArchViewModel> extends IView,LifecycleOwner {

}
