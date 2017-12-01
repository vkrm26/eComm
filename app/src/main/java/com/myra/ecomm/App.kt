package com.myra.ecomm

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.myra.ecomm.di.component.AppComponent
import com.myra.ecomm.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by vikrambhati on 24/11/17.
 */
class App : Application()/*, HasActivityInjector*/ {

//    @Inject
//    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()

//        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

    }


    companion object {
        lateinit var instance: App
            private set
    }

//    override fun activityInjector(): AndroidInjector<Activity> {
//        return activityDispatchingAndroidInjector
//    }

}