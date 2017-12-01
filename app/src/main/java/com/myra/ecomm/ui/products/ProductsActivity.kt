package com.myra.ecomm.ui.products

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.myra.ecomm.App
import com.myra.ecomm.BR

import com.myra.ecomm.R
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.databinding.ActivityProductsBinding
import com.myra.ecomm.di.component.ActivityComponent
import com.myra.ecomm.di.component.DaggerActivityComponent
import com.myra.ecomm.di.component.DaggerMainActivityComponent
import com.myra.ecomm.di.component.DaggerViewHolderComponent
import com.myra.ecomm.di.module.ActivityModule
import com.myra.ecomm.ui.base.BaseActivity
import com.myra.ecomm.ui.main.adapter.CategoryViewHolderModule
import com.myra.ecomm.ui.main.adapter.CategoryViewModel
import com.myra.ecomm.ui.main.adapter.ProductAdapter
//import com.myra.ecomm.ui.main.adapter.ProductAdapter
import javax.inject.Inject

class ProductsActivity : BaseActivity<ActivityProductsBinding, CategoryViewModel>()  {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var mActivityBinding: ActivityProductsBinding

    @Inject
    lateinit var productViewModel: CategoryViewModel

    @Inject
    lateinit var mLayoutManager: GridLayoutManager

    @Inject
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerViewHolderComponent.builder()
                .appComponent(App.instance.appComponent)
                .categoryViewHolderModule(CategoryViewHolderModule())
                .build()
                .injectProductsActivity(this)


        super.onCreate(savedInstanceState)

        mActivityBinding = viewDataBinding!!
        setup()

        if (intent != null) {
            var category = intent.getParcelableExtra<Category>("categoryId")
            Log.d("vikram", "categoryId - " + category.categoryId)
            productViewModel.setCategory(category)
        }
    }

    private fun setup() {
        mActivityBinding.recyclerProductGrid.setLayoutManager(mLayoutManager)
        mActivityBinding.recyclerProductGrid.setItemAnimator(DefaultItemAnimator())
        mActivityBinding.recyclerProductGrid.setAdapter(productAdapter)
    }

    override val viewModel : CategoryViewModel
        get() {
            productViewModel = ViewModelProviders.of(this, mViewModelFactory).get(CategoryViewModel::class.java)
            return productViewModel!!
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_products


}
