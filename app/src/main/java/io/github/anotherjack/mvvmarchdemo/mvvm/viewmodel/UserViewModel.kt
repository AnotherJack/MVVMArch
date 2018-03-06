package io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.*
import android.content.Intent
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.kingja.loadsir.callback.SuccessCallback
import com.tbruyelle.rxpermissions2.RxPermissions
import io.github.anotherjack.avoidonresult.AvoidOnResult
import io.github.anotherjack.mvvmarch.di.scope.PerActivity
import io.github.anotherjack.mvvmarch.mvvm.ArchViewModel
import io.github.anotherjack.mvvmarchdemo.app.loadsircallback.LoadingCallback
import io.github.anotherjack.mvvmarchdemo.mvvm.model.UserModel
import io.github.anotherjack.mvvmarchdemo.mvvm.model.entity.User
import io.github.anotherjack.mvvmarchdemo.mvvm.view.activity.HobbyActivity
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
    var hobby:MutableLiveData<String> = MutableLiveData()
    private val mDisposables = CompositeDisposable()

    private var initialized = false

    @Inject
    lateinit var gson:Gson

    @Inject
    lateinit var application:Application

    @Inject
    lateinit var rxPermissions:RxPermissions

    @Inject
    lateinit var holderFragment:HolderFragment

    @Inject
    lateinit var avoidOnResult:AvoidOnResult



    val state:MutableLiveData<Class<*>> = MutableLiveData()


    init {
        Log.d(TAG,"---------------- init "+this.toString())

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.d(TAG,"------------------- onCreate "+this.toString())

        if(!initialized){
            loadUser()
        }

        initialized = true //在onCreate最后标志位设为true，防止横竖屏切换时重复加载数据
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

    val REQUEST_GET_HOBBY = 123
    fun getHobby(view: View){
//        val intent = Intent(holderFragment.activity,HobbyActivity::class.java)
//        holderFragment.activity?.startActivityForResult(intent,REQUEST_GET_HOBBY)

        AvoidOnResult(holderFragment.activity).startForResult(HobbyActivity::class.java,object :AvoidOnResult.Callback{
            override fun onActivityResult(resultCode: Int, data: Intent?) {
                if (resultCode == Activity.RESULT_OK) {
                    hobby.value = data?.getStringExtra("hobby")
                }
            }

        })
    }

    fun printLog(view:View){
        Log.d("User ---> ","name:${user.value?.name}\n" +
                "age:${user.value?.age}\n" +
                "address:${user.value?.address}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(lifecycleOwner: LifecycleOwner,event: Lifecycle.Event){
        Log.d(TAG,"-------------onAny")
    }

    override fun onCleared() {
        super.onCleared()
        mDisposables.clear()
    }


}
