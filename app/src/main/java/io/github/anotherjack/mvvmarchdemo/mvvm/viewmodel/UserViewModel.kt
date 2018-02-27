package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Handler
import android.util.Log
import android.view.View
import com.bumptech.glide.RequestManager
import com.google.gson.Gson
import com.tbruyelle.rxpermissions2.RxPermissions
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.app.extension.notifyChange
import io.github.anotherjack.mvvmarchdemo.di.module.CommonActivityModule
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
class UserViewModel @Inject
constructor(mModel: UserModel) : ArchViewModel<UserModel>(mModel) {
    var user:MutableLiveData<User> = MutableLiveData()

    @Inject
    lateinit var gson:Gson

    @Inject
    lateinit var application:Application

    @Inject
    lateinit var rxPermissions:RxPermissions

    @Inject
    lateinit var requestManager:RequestManager

    @Inject
    lateinit var activityHolder:CommonActivityModule.ActivityHolder

    init {
        Log.d("userViewModel ","---------------- init "+this.toString())

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d("userVideModel ","------------------- onCreate "+this.toString())
        Log.d("getSomeData ","----------------- "+mModel.getSomeData())

        user.value = User("aaa",18,"Beijing")

        Handler().postDelayed({
            application.toast("change")
//            mViewModel.user.value = User("ccc",20,"Shanghai")

            user.value?.name = "ccc"
            user.value?.age = 20
            user.value?.address = "Shanghai"
            user.notifyChange()
        },5000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.d("userVideModel ","------------------- onResume "+this.toString())
    }

    fun printLog(view:View){
        Log.d("User ---> ","name:${user.value?.name}\n" +
                "age:${user.value?.age}\n" +
                "address:${user.value?.address}")
    }


}
