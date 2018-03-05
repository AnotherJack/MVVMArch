package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import android.view.View
import com.bumptech.glide.RequestManager
import com.google.gson.Gson
import com.kingja.loadsir.callback.SuccessCallback
import com.tbruyelle.rxpermissions2.RxPermissions
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.app.loadsircallback.LoadingCallback
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by jack on 2018/2/3.
 */
@PerActivity
class UserViewModel @Inject
constructor():ArchViewModel<UserModel>(){
    val TAG = "UserViewMode"
    var user:MutableLiveData<User> = MutableLiveData()
    private val mDisposables = CompositeDisposable()

    @Inject
    lateinit var gson:Gson

    @Inject
    lateinit var application:Application

    @Inject
    lateinit var rxPermissions:RxPermissions

    @Inject
    lateinit var requestManager:RequestManager

    val state:MutableLiveData<Class<*>> = MutableLiveData()


    init {
        Log.d(TAG,"---------------- init "+this.toString())

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d(TAG,"------------------- onCreate "+this.toString())
        loadUser()
    }

    fun loadUser(){
        mModel.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    mDisposables.add(it)
                    //开始加载时变成loading状态
                    state.postValue(LoadingCallback::class.java)
                }
                .subscribe({
                    Log.d(TAG," -----onNext")
                    user.value = it
                },{
                    //失败时变成error状态，这里用toast代替了
                    Log.d(TAG,"-----onError")
                    application.toast("出错了！")
                },{
                    Log.d(TAG,"-----onComplete")
                    //加载成功变成成功状态
                    state.value = SuccessCallback::class.java
                })
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
