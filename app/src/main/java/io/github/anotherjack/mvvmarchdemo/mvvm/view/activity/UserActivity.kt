package io.github.anotherjack.mvvmarchdemo.mvvm.view.activity

import android.os.Bundle
import com.google.gson.Gson
import io.github.anotherjack.mvvmarchdemo.R
import io.github.anotherjack.mvvmarchdemo.databinding.ActivityUserBinding
import io.github.anotherjack.mvvmarchdemo.di.component.ActivityComponent
import io.github.anotherjack.mvvmarchdemo.di.component.DaggerUserComponent
import io.github.anotherjack.mvvmarchdemo.di.component.UserComponent
import io.github.anotherjack.mvvmarchdemo.mvvm.view.base.BaseActivity
import io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel.UserViewModel
import org.jetbrains.anko.toast
import javax.inject.Inject

class UserActivity : BaseActivity<ActivityUserBinding,UserViewModel, UserComponent>() {

    @Inject
    lateinit var gson:Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.vm = mViewModel
        mViewModel.testStr = "aaaaaaaaa"
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_user
    }

    override fun buildComponent(dependencyComponent: ActivityComponent?): UserComponent {
        return DaggerUserComponent
                .builder()
                .activityComponent(dependencyComponent)
                .build()
    }

    override fun executeInject(mComponent: UserComponent?) {
        mComponent?.inject(this)
    }


}
