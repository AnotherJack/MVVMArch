package io.github.anotherjack.mvvmarchdemo.mvvm.view.activity

import android.os.Bundle
import io.github.anotherjack.mvvmarchdemo.R
import io.github.anotherjack.mvvmarchdemo.databinding.ActivityUserBinding
import io.github.anotherjack.mvvmarchdemo.di.component.AppComponent
import io.github.anotherjack.mvvmarchdemo.di.component.DaggerUserComponent
import io.github.anotherjack.mvvmarchdemo.di.component.UserComponent
import io.github.anotherjack.mvvmarchdemo.di.module.CommonActivityModule
import io.github.anotherjack.mvvmarchdemo.di.module.UserModule
import io.github.anotherjack.mvvmarchdemo.mvvm.view.base.BaseActivity
import io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel.UserViewModel

class UserActivity : BaseActivity<ActivityUserBinding,UserViewModel, UserComponent>() {

//    @Inject
//    lateinit var gson:Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.vm = mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_user
    }

    override fun buildComponent(appComponent: AppComponent?, commonActivityModule: CommonActivityModule?): UserComponent {
        return DaggerUserComponent
                .builder()
                .appComponent(appComponent)
                .commonActivityModule(commonActivityModule)
                .userModule(UserModule(this))
                .build()
    }

    override fun executeInject(mComponent: UserComponent?) {
        mComponent?.inject(this)
    }


}
