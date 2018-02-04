package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import android.app.Application
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import javax.inject.Inject

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
class UserViewModel @Inject
constructor(application: Application, mModel: UserModel) : ArchViewModel<UserModel>(application, mModel) {
    var testStr = "qwerasd"
}
