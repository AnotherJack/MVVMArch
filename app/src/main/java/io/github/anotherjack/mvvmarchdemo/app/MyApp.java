package io.github.anotherjack.mvvmarchdemo.app;

import android.app.Application;

import com.kingja.loadsir.core.LoadSir;
import com.squareup.leakcanary.LeakCanary;

import io.github.anotherjack.mvvmarchdemo.app.loadsircallback.LoadingCallback;
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
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        instance = this;
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        //loadsir 一个多状态视图框架
        LoadSir.beginBuilder()
                .addCallback(new LoadingCallback())
//                .setDefaultCallback(LoadingCallback.class)//设置默认状态页
                .commit();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
