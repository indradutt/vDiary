package com.indra.vdiary.di

import com.indra.vdiary.DiaryApp
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by indra.dutt on 4/12/18.
 */
@Module class AppModule(val app: DiaryApp) {
    @Provides @Singleton fun providesApp() = app
    //@Provides @Singleton fun providePicasso() : Picasso = Picasso.get()
}