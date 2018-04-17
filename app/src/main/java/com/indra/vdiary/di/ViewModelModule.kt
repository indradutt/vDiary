package com.indra.vdiary.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.indra.vdiary.explorer.viewmodel.ExplorerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by indra.dutt on 4/13/18.
 */
@Module internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ExplorerViewModel::class)
    internal abstract fun bindRepoViewModel(explorerViewModel: ExplorerViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}