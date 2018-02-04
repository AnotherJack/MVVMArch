package io.github.anotherjack.mvvmarchdemo.di.component;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import io.github.anotherjack.mvvmarchdemo.di.module.AppModule;
import io.github.anotherjack.mvvmarchdemo.mvvm.model.api.ApiService;

/**
 * Created by jack on 2018/2/2.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Application getApplication();

    Gson getGson();

    ApiService getApiService();
}
