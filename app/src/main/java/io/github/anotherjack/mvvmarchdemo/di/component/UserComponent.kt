package io.github.anotherjack.mvvmarchdemo.di.component

import dagger.Component
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarchdemo.di.module.UserModule
import io.github.anotherjack.mvvmarchdemo.mvvm.view.activity.UserActivity

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
@Component(modules = arrayOf(UserModule::class), dependencies = arrayOf(ActivityComponent::class))
interface UserComponent {
    fun inject(activity: UserActivity)
}
