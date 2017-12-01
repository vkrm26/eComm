package com.myra.ecomm.ui.main.adapter

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.ViewModelProviderFactory
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Product
import dagger.Module
import dagger.Provides

/**
 * Created by vikrambhati on 01/12/17.
 */
@Module()
class CategoryViewHolderModule {

    @Provides
    fun provideCategoryViewModel(dataManager: DataManager) : CategoryViewModel {
        return CategoryViewModel(dataManager)
    }

    @Provides
    fun categoryViewModelProvider(categoryViewModel: CategoryViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(categoryViewModel)
    }

    @Provides
    fun provideLinearLayoutManager(context : Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun provideGridLayoutManager(context: Context): GridLayoutManager {
        return GridLayoutManager(context, 2)
    }

    @Provides
    fun provideProductAdapter(): ProductAdapter {
        return ProductAdapter(ArrayList<Product>())
    }

}