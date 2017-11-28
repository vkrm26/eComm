package com.myra.ecomm.di.builder

import com.myra.ecomm.ui.main.MainActivity
import com.myra.ecomm.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vikrambhati on 24/11/17.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

//    @ContributesAndroidInjector(modules = arrayOf(De::class))
//    internal abstract fun bindFeedActivity(): DetailActivity

}