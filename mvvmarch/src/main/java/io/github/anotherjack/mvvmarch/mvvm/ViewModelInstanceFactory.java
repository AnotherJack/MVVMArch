package io.github.anotherjack.mvvmarch.mvvm;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * 通过构造器传入viewModel，再在create方法中将其返回，目的只是为了通过factory创建viewModel，使其可感知对应生命周期
 * Created by jack on 2018/2/1.
 */

public class ViewModelInstanceFactory<VM extends ArchViewModel> extends ViewModelProvider.NewInstanceFactory {
    private VM mViewModel;

    public ViewModelInstanceFactory(VM mViewModel) {
        this.mViewModel = mViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) mViewModel;
    }
}
