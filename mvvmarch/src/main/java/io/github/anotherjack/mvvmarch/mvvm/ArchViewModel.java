package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;
import javax.inject.Inject;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchViewModel<M extends IArchModel> extends ViewModel implements IViewModel, LifecycleObserver {
    @Inject
    protected M mModel;
}
