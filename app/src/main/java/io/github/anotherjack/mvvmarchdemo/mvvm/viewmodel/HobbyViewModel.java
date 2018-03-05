package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;

import javax.inject.Inject;

import io.github.anotherjack.mvvmarch.di.scope.PerActivity;
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel;
import io.github.anotherjack.mvvmarchdemo.mvvm.model.HobbyModel;

/**
 * Created by jack on 2018/3/5.
 */
@PerActivity
public class HobbyViewModel extends ArchViewModel<HobbyModel> {
    public MutableLiveData<String> hobby = new MutableLiveData<>();

    @Inject
    public HobbyViewModel() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

    }

}
