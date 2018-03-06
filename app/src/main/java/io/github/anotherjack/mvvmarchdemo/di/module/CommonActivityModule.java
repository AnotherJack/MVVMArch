package io.github.anotherjack.mvvmarchdemo.di.module;

import android.arch.lifecycle.HolderFragment;
import android.support.v7.app.AppCompatActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.Module;
import dagger.Provides;
import io.github.anotherjack.avoidonresult.AvoidOnResult;
import io.github.anotherjack.mvvmarch.di.scope.PerActivity;

/**
 * 存储activity中通用的东西
 * Created by jack on 2018/2/3.
 */

@Module
public class CommonActivityModule {
    private AppCompatActivity activity;

    public CommonActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public RxPermissions provideRxPermissions(){
        return new RxPermissions(activity);
    }

    /**
     * 不要这样做
     * 不要为viewmodel提供activity，在屏幕旋转时会导致内存泄漏
     * 需要activity的话可以为viewmodel注入HolderFragment，并通过HolderFragment的getActivity获得activity
     * @return
     */
//    @PerActivity
//    @Provides
//    public Activity provideActivity(){
//        return activity;
//    }

    @PerActivity
    @Provides
    public HolderFragment provideHolderFragment(){
        return HolderFragment.holderFragmentFor(activity);
    }

    @PerActivity
    @Provides
    public AvoidOnResult provideAvoidOnResult(){
        return new AvoidOnResult(activity);
    }
}
