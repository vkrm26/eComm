package com.myra.ecomm.ui.main.adapter

import android.support.v7.widget.RecyclerView
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.databinding.ItemProductBinding

/**
 * Created by vikrambhati on 27/11/17.
 */
class ProductViewHolder (productBinding: ItemProductBinding) : RecyclerView.ViewHolder(productBinding.root) {

    private val itemProductBinding = productBinding

    private lateinit var bindingViewModel : ProductItemViewModel

    fun bind(product: Product) = with(itemView) {
        bindingViewModel = ProductItemViewModel(product)
        itemProductBinding.viewModel = bindingViewModel
        itemProductBinding.executePendingBindings()
    }

}
