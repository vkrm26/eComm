package com.myra.ecomm.ui.productDetail

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.ViewModelProviderFactory
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by vikrambhati on 02/12/17.
 */
@Module()
class ProductDetailViewModule {

    @Provides
    fun provideProductDetailViewModel(dataManager: DataManager) : ProductDetailViewModel {
        return ProductDetailViewModel(dataManager)
    }

    @Provides
    fun categoryViewModelProvider(productDetailViewModel: ProductDetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(productDetailViewModel)
    }

    @Provides
    fun provideLinearLayoutManager(context : Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideProductAdapter(): ProductAdapter {
        return ProductAdapter(ArrayList<Product>())
    }

}