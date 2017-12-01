package com.myra.ecomm.ui.main.adapter

import android.databinding.ObservableField
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product

/**
 * Created by vikrambhati on 27/11/17.
 */
class ProductItemViewModel  {

    var productImg : ObservableField<String>
    var productName : ObservableField<String>
    var productId : ObservableField<Int>
    var categoryId : ObservableField<Int>

    private var product : Product
    private var productViewModelListener: ProductViewModelListener

    constructor(product: Product, viewModelListener: ProductViewModelListener) {
        this.product = product
        this.productViewModelListener = viewModelListener
        productImg = ObservableField<String>(product.productName.substring(0,1))
        productName = ObservableField<String>(product.productName)
        productId = ObservableField<Int>(product.productId)
        categoryId = ObservableField<Int>(product.categoryId)
    }

    interface ProductViewModelListener {
        fun openProductDetailClick(product: Product)
    }

    fun openProductDetail() {
        productViewModelListener.openProductDetailClick(product)
    }

}