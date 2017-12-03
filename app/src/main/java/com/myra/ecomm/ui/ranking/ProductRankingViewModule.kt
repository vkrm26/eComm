package com.myra.ecomm.ui.ranking

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.ViewModelProviderFactory
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by vikrambhati on 03/12/17.
 */
@Module
class ProductRankingViewModule {

    @Provides
    fun provideProductRankingViewModel(dataManager: DataManager) : ProductRankingViewModel {
        return ProductRankingViewModel(dataManager)
    }

    @Provides
    fun categoryViewModelProvider(productRankingViewModel: ProductRankingViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(productRankingViewModel)
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