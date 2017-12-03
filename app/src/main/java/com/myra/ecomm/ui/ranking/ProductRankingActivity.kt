package com.myra.ecomm.ui.ranking

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.App
import com.myra.ecomm.BR

import com.myra.ecomm.R
import com.myra.ecomm.databinding.ActivityProductRankingBinding
import com.myra.ecomm.di.component.DaggerProductRankingComponent
import com.myra.ecomm.ui.base.BaseActivity
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import javax.inject.Inject

class ProductRankingActivity : BaseActivity<ActivityProductRankingBinding, ProductRankingViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var mActivityBinding: ActivityProductRankingBinding

    @Inject
    lateinit var productDetailViewModel: ProductRankingViewModel

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    @Inject
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerProductRankingComponent
                .builder()
                .appComponent(App.instance.appComponent)
                .productRankingViewModule(ProductRankingViewModule())
                .build()
                .injectActivity(this)

        super.onCreate(savedInstanceState)

        mActivityBinding = viewDataBinding!!
        setup()

        productDetailViewModel.getProductByRanking(0)

    }

    private fun setup() {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mActivityBinding.productRecyclerView.setLayoutManager(mLayoutManager)
        mActivityBinding.productRecyclerView.setItemAnimator(DefaultItemAnimator())
        mActivityBinding.productRecyclerView.setAdapter(productAdapter)
    }

    override val viewModel: ProductRankingViewModel
        get() {
            productDetailViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ProductRankingViewModel::class.java)
            return productDetailViewModel!!
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_product_ranking

}
