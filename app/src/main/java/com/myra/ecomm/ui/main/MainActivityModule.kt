package com.myra.ecomm.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.ViewModelProviderFactory
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.main.adapter.CategoryAdapter
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import dagger.Module
import dagger.Provides
import java.util.ArrayList

/**
 * Created by vikrambhati on 24/11/17.
 */
@Module()
class MainActivityModule {

    @Provides
    fun provideMainViewModel(dataManager: DataManager): MainViewModel {
        return MainViewModel(dataManager)
    }

    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideGridLayoutManager(context: Context): GridLayoutManager {
        return GridLayoutManager(context, 2)
    }

    @Provides
    fun provideCategoryAdapter(): CategoryAdapter {
        return CategoryAdapter(ArrayList<Category>())
    }

    @Provides
    fun provideProductsAdapter(): ProductAdapter {
        return ProductAdapter(ArrayList<Product>())
    }

}