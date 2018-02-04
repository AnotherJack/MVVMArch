package io.github.anotherjack.mvvmarchdemo.di.module;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.anotherjack.mvvmarchdemo.mvvm.model.api.ApiService;
import io.github.anotherjack.mvvmarchdemo.mvvm.model.api.ServiceGenerator;

/**
 * Created by jack on 2018/2/2.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication(){
        return application;
    }

    @Singleton
    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(){
        return ServiceGenerator.createService(ApiService.class);
    }

}
