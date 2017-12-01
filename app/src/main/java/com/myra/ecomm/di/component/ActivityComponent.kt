package com.myra.ecomm.di.component

import com.myra.ecomm.di.annotations.PerActivity
import com.myra.ecomm.di.module.ActivityModule
import com.myra.ecomm.ui.navigator.Navigator
import dagger.Component

/**
 * Created by vikrambhati on 29/11/17.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent : AppComponent {

    fun navigator(): Navigator
//
//    fun layoutManager(): LinearLayoutManager
//
//    fun gridLayoutManager(): GridLayoutManager
//
//    fun injectMainActivity(activity: MainActivity)
//
//    fun injectProductsActivity(activity: ProductsActivity)
//
//    fun injectProductDetailActivity(activity: ProductDetailActivity)

}