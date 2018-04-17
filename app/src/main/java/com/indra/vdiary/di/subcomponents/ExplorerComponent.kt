package com.indra.vdiary.di.subcomponents

import com.indra.vdiary.di.FragmentScope
import com.indra.vdiary.di.RepositoryModule
import com.indra.vdiary.explorer.views.ExplorerFragment
import dagger.Subcomponent

/**
 * Created by indra.dutt on 4/17/18.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(ExplorerModule::class, RepositoryModule::class))
interface ExplorerComponent {
    fun inject(fragment: ExplorerFragment)
}