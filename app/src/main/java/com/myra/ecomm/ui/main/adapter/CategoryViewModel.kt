package com.myra.ecomm.ui.main.adapter

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.base.BaseViewModel
import com.myra.ecomm.ui.navigator.Navigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by vikrambhati on 26/11/17.
 */
class CategoryViewModel(dataManager: DataManager, categoryItem: Category, categoryViewModelListener: CategoryViewModelListener) : BaseViewModel<Navigator>(dataManager) {

    val category = categoryItem
    var categoryName: ObservableField<String>
    var productList: ObservableArrayList<Product>
    var categoryViewListener : CategoryViewModelListener = categoryViewModelListener

    init {
        categoryName = ObservableField<String>(category.categoryName)
        productList = ObservableArrayList()
        getProductsForThisCategory(category.categoryId)
    }

    fun getProductsForThisCategory(categoryId: Int) {
        setIsLoading(true)
        getCompositeDisposable().add(getDataManager()
                .getAllProductFromGivenCategory(categoryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    result -> result.size
                    productList.clear()
                    productList.addAll(result)

                    setIsLoading(false)
                    Log.d("vikram", "category size - " + result.size)
                }))
    }

    interface CategoryViewModelListener {
        fun onMoreOptionClick(category: Category)
    }

    fun onMoreOptionClick() {
        categoryViewListener.onMoreOptionClick(category)
    }

}