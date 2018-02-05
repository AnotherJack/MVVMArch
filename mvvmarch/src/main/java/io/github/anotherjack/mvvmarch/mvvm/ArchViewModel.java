package io.github.anotherjack.mvvmarch.mvvm;

import android.app.Application;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchViewModel<M extends IArchModel> extends ViewModel implements IViewModel, LifecycleObserver {
    protected M mModel;

    public ArchViewModel(M mModel) {
        this.mModel = mModel;
    }
}
