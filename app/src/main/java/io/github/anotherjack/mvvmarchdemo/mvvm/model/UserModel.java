package io.github.anotherjack.mvvmarchdemo.mvvm.model;

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.scope.PerActivity;
import io.github.anotherjack.mvvmarch.mvvm.IArchModel;

/**
 * Created by jack on 2018/2/2.
 */
@PerActivity
public class UserModel implements IArchModel{
    @Inject
    public UserModel() {
    }

    public String getSomeData(){
        return "Some data!";
    }
}
