package com.myra.ecomm.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.ViewModelProviderFactory
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.ui.main.adapter.CategoryAdapter
import dagger.Module
import dagger.Provides
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by vikrambhati on 24/11/17.
 */
@Module
class MainActivityModule {

    private val activity : AppCompatActivity

    @Inject
    constructor(mActivity: AppCompatActivity) {
        this.activity = mActivity
    }

    @Provides
    fun provideMainViewModel(dataManager: DataManager): MainViewModel {
        return MainViewModel(dataManager)
    }

    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }

    @Provides
    fun provideCategoryAdapter(): CategoryAdapter {
        return CategoryAdapter(ArrayList<Category>())
    }
}