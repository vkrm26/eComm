package com.myra.ecomm.ui.main.adapter

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.databinding.ItemCategoryBinding
import com.myra.ecomm.ui.base.BaseViewHolder
import javax.inject.Inject

/**
 * Created by vikrambhati on 26/11/17.
 */
class CategoryViewHolder (categoryBinding: ItemCategoryBinding) : BaseViewHolder<ItemCategoryBinding, CategoryViewModel>(categoryBinding.root) {

    private val itemCategoryBinding = categoryBinding

    private lateinit var bindingViewModel : CategoryViewModel

    @Inject
    lateinit var productAdapter : ProductAdapter

    init {
        viewHolderComponent().inject(this)
    }

    fun bind(category: Category) = with(itemView) {


        bindingViewModel = CategoryViewModel(dataManager!!, category)
        itemCategoryBinding.viewModel = bindingViewModel

        var mLayoutManager =  LinearLayoutManager(itemCategoryBinding.textView.context)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        itemCategoryBinding.recyclerProduct.setLayoutManager(mLayoutManager)
        itemCategoryBinding.recyclerProduct.setItemAnimator(DefaultItemAnimator())

        itemCategoryBinding.recyclerProduct.setAdapter(productAdapter)

        itemCategoryBinding.executePendingBindings()
    }

}
