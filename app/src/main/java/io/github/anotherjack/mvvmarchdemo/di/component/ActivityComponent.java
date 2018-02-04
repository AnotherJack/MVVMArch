package io.github.anotherjack.mvvmarchdemo.di.component;


import com.bumptech.glide.RequestManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Component;
import io.github.anotherjack.mvvmarch.di.scope.ActivityScope;
import io.github.anotherjack.mvvmarchdemo.di.module.ActivityModule;

/**
 * Created by jack on 2018/2/3.
 */

@ActivityScope
@Component(modules = {ActivityModule.class},dependencies = {AppComponent.class})
public interface ActivityComponent extends AppComponent{

    RxPermissions getRxPermissions();

    RequestManager getRequestManager();

}
