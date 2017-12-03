package com.myra.ecomm.ui.productDetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.myra.ecomm.App
import com.myra.ecomm.BR

import com.myra.ecomm.R
import com.myra.ecomm.Util
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.databinding.ActivityDetailBinding
import com.myra.ecomm.di.component.DaggerProductDetailComponent
import com.myra.ecomm.ui.base.BaseActivity
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import javax.inject.Inject

class ProductDetailActivity : BaseActivity<ActivityDetailBinding, ProductDetailViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var mActivityBinding: ActivityDetailBinding

    @Inject
    lateinit var productDetailViewModel: ProductDetailViewModel

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    @Inject
    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerProductDetailComponent.builder()
                .appComponent(App.instance.appComponent)
                .productDetailViewModule(ProductDetailViewModule())
                .build()
                .injectProductDetailActivity(this)


        super.onCreate(savedInstanceState)

        mActivityBinding = viewDataBinding!!

        setup()

        if (intent != null) {
            var product = intent.getParcelableExtra<Product>("product")
            Log.d("vikram", "productId - " + product.productId)

            var layoutParams = LinearLayout.LayoutParams(100, 100)
            layoutParams.rightMargin = 20
            layoutParams.gravity = Gravity.CENTER

            var colorMap = HashMap<String, Int>()
            var sizeMap = HashMap<String, Int>()
            for (variant in product.variantInfo!!) {

                if (!colorMap.containsKey(variant.color)) {
                    colorMap.put(variant.color, Util.getColor(variant.color))

                    var textView = TextView(this)
                    textView.gravity = Gravity.CENTER
                    textView.background = ContextCompat.getDrawable(this, colorMap.get(variant.color)!!)
                    textView.layoutParams = layoutParams

                    mActivityBinding.layoutColors.addView(textView)
                }

                if (!TextUtils.isEmpty(variant.size) && !sizeMap.containsKey(variant.size)) {
                    sizeMap.put(variant.size, 1)

                    var textView = TextView(this)

                    textView.setText(variant.size)
                    textView.gravity = Gravity.CENTER
                    textView.background = ContextCompat.getDrawable(this, R.drawable.size_background)
                    textView.layoutParams = layoutParams

                    mActivityBinding.layoutSize.addView(textView)
                }
            }

            if (colorMap.isEmpty()) {
                mActivityBinding.dividerColor.visibility = View.GONE
                mActivityBinding.layoutColors.visibility = View.GONE
                mActivityBinding.headingAvailableColor.visibility = View.GONE
            }

            if (sizeMap.isEmpty()) {
                mActivityBinding.dividerSelectSize.visibility = View.GONE
                mActivityBinding.layoutSize.visibility = View.GONE
                mActivityBinding.headingSelectSize.visibility = View.GONE
            }

            productDetailViewModel.setProduct(product)
        }
    }

    private fun setup() {
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mActivityBinding.recyclerProduct.setLayoutManager(mLayoutManager)
        mActivityBinding.recyclerProduct.setItemAnimator(DefaultItemAnimator())
        mActivityBinding.recyclerProduct.setAdapter(productAdapter)
    }

    override val viewModel: ProductDetailViewModel
        get() {
            productDetailViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ProductDetailViewModel::class.java)
            return productDetailViewModel!!
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_detail


}
