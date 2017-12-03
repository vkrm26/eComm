package com.myra.ecomm.di.component

import android.app.Application
import android.content.Context
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by vikrambhati on 24/11/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun getContext() : Context

    fun getDataManager() : DataManager

}