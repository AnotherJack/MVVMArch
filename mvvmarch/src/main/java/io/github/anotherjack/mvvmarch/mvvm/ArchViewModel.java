package io.github.anotherjack.mvvmarch.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;

/**
 * Created by jack on 2018/1/31.
 */

public abstract class ArchViewModel<M extends IArchModel,L extends Lifecycle> extends AndroidViewModel implements IViewModel {
    protected M mModel;
    protected L mLifecycle;

    public ArchViewModel(@NonNull Application application) {
        super(application);
    }
}
