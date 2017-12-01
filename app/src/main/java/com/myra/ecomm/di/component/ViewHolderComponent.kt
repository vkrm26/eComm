package com.myra.ecomm.di.component

import android.content.Context
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.di.annotations.AScope
import com.myra.ecomm.ui.main.MainActivity
import com.myra.ecomm.ui.main.adapter.CategoryViewHolder
import com.myra.ecomm.ui.main.adapter.CategoryViewHolderModule
import com.myra.ecomm.ui.main.adapter.CategoryViewModel
import com.myra.ecomm.ui.products.ProductsActivity
import dagger.Component

/**
 * Created by vikrambhati on 28/11/17.
 */
@AScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(CategoryViewHolderModule::class))
interface ViewHolderComponent : AppComponent {

    fun inject(viewHolder: CategoryViewHolder)

    fun injectProductsActivity(productsActivity: ProductsActivity)

}
