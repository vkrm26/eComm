package com.myra.ecomm.ui.products

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.di.annotations.PerActivity
//import com.myra.ecomm.ui.main.adapter.ProductAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by vikrambhati on 01/12/17.
 */
@Module
abstract class ProductsActivityModule(activity: AppCompatActivity) {

    var mActivity = activity

    @Provides
    @PerActivity
    fun provideActivityContext(): Context {
        return mActivity
    }

    @Provides
    fun provideProductsViewModel(dataManager: DataManager): ProductsViewModel {
        return ProductsViewModel(dataManager)
    }

    @Provides
    fun provideGridLayoutManager(): GridLayoutManager {
        return GridLayoutManager(mActivity, 2)
    }

//    @Provides
//    fun provideProductsAdapter(): ProductAdapter {
//        return ProductAdapter(ArrayList<Product>())
//    }
}