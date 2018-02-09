package io.github.anotherjack.mvvmarchdemo.app.extension

import android.arch.lifecycle.MutableLiveData

/**
 * Created by zhengj on 2018-2-9.
 */

fun <T> MutableLiveData<T>.notifyChange(){
    this.value = this.value
}