package io.github.anotherjack.mvvmarch.mvvm;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModel;

/**
 * Created by jack on 2018/1/31.
 */

public class ArchViewModel<M extends IModel,L extends Lifecycle> extends ViewModel implements IViewModel {
    protected M mModel;
    protected L mLifecycle;

    public ArchViewModel(M mModel, L mLifecycle) {
        this.mModel = mModel;
        this.mLifecycle = mLifecycle;
    }
}
