package com.myra.ecomm.di.component

import com.myra.ecomm.di.annotations.AScope
import com.myra.ecomm.ui.main.MainActivity
import com.myra.ecomm.ui.main.MainActivityModule
import com.myra.ecomm.ui.products.ProductsActivity
import dagger.Component

/**
 * Created by vikrambhati on 01/12/17.
 */
@AScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}