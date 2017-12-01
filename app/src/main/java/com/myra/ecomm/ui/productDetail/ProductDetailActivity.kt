package com.myra.ecomm.ui.productDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.myra.ecomm.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent != null) {
            var productId = intent.getIntExtra("productId", -1)
            Log.d("vikram", "productId - " + productId)
        }
    }
}
