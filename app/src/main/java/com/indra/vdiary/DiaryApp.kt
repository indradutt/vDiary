package com.indra.vdiary

import android.app.Application
import com.indra.vdiary.di.AppComponent
import com.indra.vdiary.di.DaggerAppComponent

/**
 * Created by indra.dutt on 4/12/18.
 */
class DiaryApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}