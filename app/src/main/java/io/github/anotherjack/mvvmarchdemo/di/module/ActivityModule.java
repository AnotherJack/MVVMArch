package io.github.anotherjack.mvvmarchdemo.di.module;

import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;
import io.github.anotherjack.mvvmarch.di.scope.ActivityScope;

/**
 * Created by jack on 2018/2/3.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public RxPermissions provideRxPermissions(){
        return new RxPermissions(activity);
    }

    @ActivityScope
    @Provides
    public RequestManager provideRequestManager(){
        return Glide.with(activity);
    }
}
