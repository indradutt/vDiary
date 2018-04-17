package com.indra.vdiary.di

import com.indra.vdiary.explorer.model.ExplorerRepo
import dagger.Binds
import dagger.Module

/**
 * Created by indra.dutt on 4/13/18.
 */
@Module abstract class RepositoryModule {
    @Binds @FragmentScope abstract fun providesExplorerRepo(explorerRepo: ExplorerRepo) : ExplorerRepo
}