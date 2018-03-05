package io.github.anotherjack.mvvmarchdemo.mvvm.model;

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.scope.PerActivity;
import io.github.anotherjack.mvvmarch.mvvm.IArchModel;

/**
 * Created by jack on 2018/3/5.
 */
@PerActivity
public class HobbyModel implements IArchModel {
    @Inject
    public HobbyModel() {
    }
}
