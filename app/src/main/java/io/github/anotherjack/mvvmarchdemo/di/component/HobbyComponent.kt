package io.github.anotherjack.mvvmarchdemo.di.component

import dagger.Component
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarchdemo.di.module.CommonActivityModule
import io.github.anotherjack.mvvmarchdemo.mvvm.view.activity.HobbyActivity

/**
 * Created by jack on 2018/3/5.
 */
@PerActivity
@Component(modules = arrayOf(CommonActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface HobbyComponent{
    fun inject(hobbyActivity: HobbyActivity)
}