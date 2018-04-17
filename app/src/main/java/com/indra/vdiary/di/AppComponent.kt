package com.indra.vdiary.di

import com.indra.vdiary.DiaryApp
import com.indra.vdiary.di.subcomponents.ExplorerComponent
import com.indra.vdiary.di.subcomponents.ExplorerModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by indra.dutt on 4/12/18.
 */
@Singleton
@Component (modules = arrayOf(AppModule::class, ViewModelModule::class))
interface AppComponent {
    fun inject(app: DiaryApp)
    fun plus(explorerModule: ExplorerModule) : ExplorerComponent
}