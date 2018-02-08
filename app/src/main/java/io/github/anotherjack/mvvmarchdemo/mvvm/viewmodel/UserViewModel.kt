package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User
import javax.inject.Inject

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
class UserViewModel @Inject
constructor(mModel: UserModel) : ArchViewModel<UserModel>(mModel) {
    var user:MutableLiveData<User> = MutableLiveData()

    fun printLog(view:View){
        Log.d("User ---> ","name:${user.value?.name}\n" +
                "age:${user.value?.age}\n" +
                "address:${user.value?.address}")
    }
}
