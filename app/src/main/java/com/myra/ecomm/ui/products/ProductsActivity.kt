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
import com.myra.ecomm.databinding.ActivityProductsBinding
import com.myra.ecomm.di.component.ActivityComponent
import com.myra.ecomm.di.component.DaggerActivityComponent
import com.myra.ecomm.di.component.DaggerMainActivityComponent
import com.myra.ecomm.di.module.ActivityModule
import com.myra.ecomm.ui.base.BaseActivity
import com.myra.ecomm.ui.main.adapter.ProductAdapter
//import com.myra.ecomm.ui.main.adapter.ProductAdapter
import javax.inject.Inject

class ProductsActivity : BaseActivity<ActivityProductsBinding, ProductsViewModel>()  {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var mActivityBinding: ActivityProductsBinding

    var productViewModel: ProductsViewModel? = null

    @Inject
    lateinit var mLayoutManager: GridLayoutManager

    @Inject
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerMainActivityComponent
                .builder()
                .appComponent(App.instance.appComponent)
                .build()
                .injectProductsActivity(this)


        super.onCreate(savedInstanceState)

        mActivityBinding = viewDataBinding!!
        setup()

        if (intent != null) {
            var categoryId = intent.getIntExtra("categoryId", -1)
            Log.d("vikram", "categoryId - " + categoryId)
        }
    }

    private fun setup() {
        mActivityBinding.recyclerProductGrid.setLayoutManager(mLayoutManager)
        mActivityBinding.recyclerProductGrid.setItemAnimator(DefaultItemAnimator())
        mActivityBinding.recyclerProductGrid.setAdapter(productAdapter)
    }

    override val viewModel : ProductsViewModel
        get() {
            productViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ProductsViewModel::class.java)
            return productViewModel!!
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_products


}
