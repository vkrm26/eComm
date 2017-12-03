package com.myra.ecomm

import android.app.Application
import com.facebook.stetho.Stetho
import com.myra.ecomm.di.component.AppComponent
import com.myra.ecomm.di.component.DaggerAppComponent

/**
 * Created by vikrambhati on 24/11/17.
 */
class App : Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

    }


    companion object {
        lateinit var instance: App
            private set
    }
}