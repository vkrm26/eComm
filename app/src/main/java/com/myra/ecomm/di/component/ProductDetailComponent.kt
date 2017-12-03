package com.myra.ecomm.di.component

import com.myra.ecomm.di.annotations.AScope
import com.myra.ecomm.ui.productDetail.ProductDetailActivity
import com.myra.ecomm.ui.productDetail.ProductDetailViewModule
import dagger.Component

/**
 * Created by vikrambhati on 02/12/17.
 */
@AScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ProductDetailViewModule::class))
interface ProductDetailComponent : AppComponent {

    fun injectProductDetailActivity(productDetailActivity: ProductDetailActivity)

}