//package com.myra.ecomm.di.builder
//
//import com.myra.ecomm.ui.main.MainActivity
//import com.myra.ecomm.ui.main.MainActivityModule
//import com.myra.ecomm.ui.products.ProductsActivity
//import com.myra.ecomm.ui.products.ProductsActivityModule
//import dagger.Module
//import dagger.android.ContributesAndroidInjector
//
///**
// * Created by vikrambhati on 24/11/17.
// */
//@Module
//abstract class ActivityBuilder {
//
//    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
//    abstract fun bindMainActivity(): MainActivity
//
//    @ContributesAndroidInjector(modules = arrayOf(ProductsActivityModule::class))
//    internal abstract fun bindProductsActivity(): ProductsActivity
//
//}6