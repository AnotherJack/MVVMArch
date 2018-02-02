package io.github.anotherjack.mvvmarch.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchViewModel<M extends IArchModel> extends AndroidViewModel implements IViewModel, LifecycleObserver {
    protected M mModel;

    public ArchViewModel(@NonNull Application application, M mModel) {
        super(application);
        this.mModel = mModel;
    }

}
