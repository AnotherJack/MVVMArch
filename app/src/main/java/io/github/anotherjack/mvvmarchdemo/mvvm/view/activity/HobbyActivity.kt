package io.github.anotherjack.mvvmarchdemo.mvvm.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import io.github.anotherjack.mvvmarchdemo.R
import io.github.anotherjack.mvvmarchdemo.databinding.ActivityHobbyBinding
import io.github.anotherjack.mvvmarchdemo.di.component.AppComponent
import io.github.anotherjack.mvvmarchdemo.di.component.DaggerHobbyComponent
import io.github.anotherjack.mvvmarchdemo.di.component.HobbyComponent
import io.github.anotherjack.mvvmarchdemo.di.module.CommonActivityModule
import io.github.anotherjack.mvvmarchdemo.mvvm.view.base.BaseActivity
import io.github.anotherjack.mvvmarchdemo.mvvm.viewmodel.HobbyViewModel

class HobbyActivity :BaseActivity<ActivityHobbyBinding,HobbyViewModel,HobbyComponent>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.vm = mViewModel

        mBinding.ok.setOnClickListener {
            val intent = Intent()
            intent.putExtra("hobby",mViewModel.hobby.value)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_hobby
    }

    override fun executeInject(mComponent: HobbyComponent?) {
        mComponent?.inject(this)
    }

    override fun buildComponent(appComponent: AppComponent?, commonActivityModule: CommonActivityModule?): HobbyComponent {
        return DaggerHobbyComponent
                .builder()
                .appComponent(appComponent)
                .commonActivityModule(commonActivityModule)
                .build()
    }


}
