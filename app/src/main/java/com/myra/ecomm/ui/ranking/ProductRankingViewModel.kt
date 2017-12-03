package com.myra.ecomm.ui.ranking

import android.databinding.ObservableArrayList
import android.util.Log
import android.widget.Toast
import com.myra.ecomm.App
import com.myra.ecomm.R
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.ui.base.BaseViewModel
import com.myra.ecomm.ui.navigator.Navigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by vikrambhati on 03/12/17.
 */
class ProductRankingViewModel(dataManager: DataManager) : BaseViewModel<Navigator>(dataManager) {

    var productList: ObservableArrayList<Product>

    init {
        productList = ObservableArrayList()
    }

    fun getProductByRanking(orderType: Int) {
        setIsLoading(true)
        getCompositeDisposable().add(getDataManager()
                .getAllProductByRanking(orderType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    result -> result.size
                    productList.clear()
                    productList.addAll(result)
                    setIsLoading(false)
                }, {
                    setIsLoading(false)
                    Toast.makeText(App.instance.applicationContext,
                            App.instance.applicationContext.getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
                }))
    }

}