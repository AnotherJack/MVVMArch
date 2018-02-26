package io.github.anotherjack.mvvmarchdemo.di.module

import dagger.Module
import io.github.anotherjack.mvvmarchdemo.mvvm.view.activity.UserActivity

/**
 * Created by jack on 2018/2/3.
 */

@Module
class UserModule(userActivity: UserActivity){
    //提供一些useractivity独有的东西

}
