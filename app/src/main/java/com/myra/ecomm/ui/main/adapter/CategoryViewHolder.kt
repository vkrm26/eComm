package com.myra.ecomm.ui.main.adapter

import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.App
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.databinding.ItemCategoryBinding
import com.myra.ecomm.di.component.DaggerViewHolderComponent
import com.myra.ecomm.ui.base.BaseViewHolder
import com.myra.ecomm.ui.productDetail.ProductDetailActivity
import javax.inject.Inject

/**
 * Created by vikrambhati on 26/11/17.
 */
class CategoryViewHolder (categoryBinding: ItemCategoryBinding) : BaseViewHolder<ItemCategoryBinding, CategoryViewModel>(categoryBinding.root), CategoryViewModel.CategoryViewModelListener {

    private val itemCategoryBinding = categoryBinding

    private lateinit var bindingViewModel : CategoryViewModel

    @Inject
    lateinit var layoutManager : LinearLayoutManager

    @Inject
    lateinit var productAdapter : ProductAdapter

    @Inject
    lateinit var categoryViewModel: CategoryViewModel

    private var viewHolder: CategoryViewHolder


    init {

        viewHolder = this

        DaggerViewHolderComponent.builder()
                .appComponent(App.instance.appComponent)
                .categoryViewHolderModule(CategoryViewHolderModule())
                .build()
                .inject(this)
    }


    fun bind(category: Category) = with(itemView) {
        bindingViewModel = categoryViewModel!!
        itemCategoryBinding.viewModel = bindingViewModel

        bindingViewModel.setCategory(category)
        bindingViewModel.categoryViewListener = viewHolder

        layoutManager!!.orientation = LinearLayoutManager.HORIZONTAL
        itemCategoryBinding.recyclerProduct.setLayoutManager(layoutManager)
        itemCategoryBinding.recyclerProduct.setItemAnimator(DefaultItemAnimator())
        itemCategoryBinding.recyclerProduct.setAdapter(productAdapter)

        itemCategoryBinding.executePendingBindings()
    }

    override fun onMoreOptionClick(category: Category) {
        var intent = Intent(itemCategoryBinding.root.context, ProductDetailActivity::class.java)
        intent.putExtra("categoryId", category.categoryId)
        itemCategoryBinding.root.context.startActivity(intent)
    }

}
