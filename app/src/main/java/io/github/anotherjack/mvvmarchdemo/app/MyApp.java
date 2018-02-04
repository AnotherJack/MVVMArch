package io.github.anotherjack.mvvmarchdemo.app;

import android.app.Application;

import io.github.anotherjack.mvvmarchdemo.di.component.AppComponent;
import io.github.anotherjack.mvvmarchdemo.di.component.DaggerAppComponent;
import io.github.anotherjack.mvvmarchdemo.di.module.AppModule;

/**
 * Created by jack on 2018/2/2.
 */

public class MyApp extends Application {
    private static MyApp instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
