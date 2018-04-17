package com.indra.vdiary.di

import com.indra.vdiary.DiaryApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by indra.dutt on 4/12/18.
 */
@Module class AppModule(val app: DiaryApp) {
    @Provides @Singleton fun providesApp() = app
}