package io.github.anotherjack.mvvmarchdemo.di.module;

import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;
import io.github.anotherjack.mvvmarch.di.scope.PerActivity;

/**
 * 存储activity中通用的东西
 * Created by jack on 2018/2/3.
 */

@Module
public class CommonActivityModule {
    private Activity activity;

    public CommonActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public RxPermissions provideRxPermissions(){
        return new RxPermissions(activity);
    }

    @PerActivity
    @Provides
    public RequestManager provideRequestManager(){
        return Glide.with(activity);
    }

    @PerActivity
    @Provides
    public Activity provideActivity(){
        return activity;
    }

}
