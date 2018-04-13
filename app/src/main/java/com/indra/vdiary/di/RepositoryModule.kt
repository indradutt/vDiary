package com.indra.vdiary.di

import com.indra.vdiary.explorer.model.ExplorerRepo
import dagger.Module
import dagger.Provides

/**
 * Created by idutt on 4/13/18.
 */
@Module abstract class RepositoryModule {
    @Provides fun providesExplorerRepo() : ExplorerRepo {
        return ExplorerRepo()
    }
}