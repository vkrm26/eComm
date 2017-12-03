package com.myra.ecomm.di.component

import com.myra.ecomm.di.annotations.AScope
import com.myra.ecomm.ui.ranking.ProductRankingActivity
import com.myra.ecomm.ui.ranking.ProductRankingViewModule
import dagger.Component

/**
 * Created by vikrambhati on 03/12/17.
 */
@AScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ProductRankingViewModule::class))
interface ProductRankingComponent : AppComponent {

    fun injectActivity(productRankingActivity: ProductRankingActivity)

}