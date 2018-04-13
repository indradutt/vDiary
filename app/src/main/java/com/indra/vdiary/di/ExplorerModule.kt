package com.indra.vdiary.di

import com.indra.vdiary.explorer.views.ExplorerFragment
import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by idutt on 4/12/18.
 */
@Module class ExplorerModule (fragment: ExplorerFragment) {

}

@ActivityScope
@Subcomponent(modules = arrayOf(ExplorerModule::class, RepositoryModule::class))
interface ExplorerComponent {
    fun inject(fragment: ExplorerFragment)
}