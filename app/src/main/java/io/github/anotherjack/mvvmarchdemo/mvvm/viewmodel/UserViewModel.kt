package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import javax.inject.Inject

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
class UserViewModel @Inject
constructor(mModel: UserModel) : ArchViewModel<UserModel>(mModel) {
    var testStr = "qwerasd"
}
