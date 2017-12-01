package com.myra.ecomm.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.main.adapter.CategoryAdapter
import com.myra.ecomm.ui.main.adapter.ProductAdapter
import java.util.ArrayList

/**
 * Created by vikrambhati on 27/11/17.
 */
@BindingAdapter("adapter")
fun addCategoryItems(recyclerView: RecyclerView,
                 categoryList: MutableList<Category>) {
    val adapter = recyclerView.adapter as? CategoryAdapter
    if (adapter != null) {
        adapter!!.clearItems()
        adapter!!.addItems(categoryList)
    }
}

//@BindingAdapter("productAdapter")
//fun addProductItems(recyclerView: RecyclerView,
//                     productList: MutableList<Product>) {
//    val adapter = recyclerView.adapter as? ProductAdapter
//    if (adapter != null) {
//        adapter!!.clearItems()
//        adapter!!.addItems(productList)
//    }
//}

