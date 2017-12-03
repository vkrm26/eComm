package com.myra.ecomm.ui.main.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.databinding.ItemProductBinding
import com.myra.ecomm.ui.productDetail.ProductDetailActivity

/**
 * Created by vikrambhati on 27/11/17.
 */
class ProductViewHolder (productBinding: ItemProductBinding) : RecyclerView.ViewHolder(productBinding.root), ProductItemViewModel.ProductViewModelListener {


    private val itemProductBinding = productBinding

    private lateinit var bindingViewModel : ProductItemViewModel

    var productViewModelListener: ProductItemViewModel.ProductViewModelListener = this

    fun bind(product: Product) = with(itemView) {
        bindingViewModel = ProductItemViewModel(product, productViewModelListener)
        itemProductBinding.viewModel = bindingViewModel
        itemProductBinding.executePendingBindings()
    }

    override fun openProductDetailClick(product: Product) {
        var intent = Intent(itemProductBinding.root.context, ProductDetailActivity::class.java)
        intent.putExtra("product", product)
        itemProductBinding.root.context.startActivity(intent)
    }
}
