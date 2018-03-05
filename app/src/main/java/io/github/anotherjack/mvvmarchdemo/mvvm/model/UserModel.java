package io.github.anotherjack.mvvmarchdemo.mvvm.model;

import com.google.gson.Gson;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.scope.PerActivity;
import io.github.anotherjack.mvvmarch.mvvm.IArchModel;
import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User;
import io.reactivex.Observable;

/**
 * Created by jack on 2018/2/2.
 */
@PerActivity
public class UserModel implements IArchModel{
    @Inject
    public UserModel() {
    }

    public Observable<User> getUser(){
        return Observable.just(new User("aaa",18,"Beijing"))
                .delay(3, TimeUnit.SECONDS);
    }
}
