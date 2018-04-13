package com.indra.vdiary.di

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * Created by indra.dutt on 4/12/18.
 */
@Module abstract class ActivityModule (private val activity: AppCompatActivity) {

    @Provides @ActivityScope fun provideActivity() : AppCompatActivity = activity

    @Provides @ActivityScope fun provideContext() : Context = activity.baseContext
}