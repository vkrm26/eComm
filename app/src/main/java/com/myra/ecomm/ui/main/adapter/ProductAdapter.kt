package com.myra.ecomm.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.databinding.ItemProductBinding
import javax.inject.Inject

/**
 * Created by vikrambhati on 27/11/17.
 */

class ProductAdapter(productList: MutableList<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    var mItems = productList


    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var itemProduct = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        var productViewHolder = ProductViewHolder(itemProduct)
        return productViewHolder
    }

    override fun onBindViewHolder(productViewHolder: ProductViewHolder, position: Int) {
        productViewHolder.bind(mItems.get(position))
    }

    fun clearItems() {
        mItems.clear()
    }

    fun addItems(categoryList: List<Product>) {
        mItems.addAll(categoryList)
        notifyDataSetChanged()
    }


}