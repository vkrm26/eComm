package com.myra.ecomm.ui.main

import android.databinding.ObservableArrayList
import android.widget.Toast
import com.myra.ecomm.App
import com.myra.ecomm.R
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by vikrambhati on 24/11/17.
 */
class MainViewModel(dataManager: DataManager) : BaseViewModel<MainNavigator>(dataManager) {

    val categoryList = ObservableArrayList<Category>()

    init {
        fetchDataFromServer()
    }

    fun fetchDataFromServer() {
        setIsLoading(true)
        getCompositeDisposable().add(getDataManager()
                .getAllCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    result -> result.size
                    categoryList.clear()
                    categoryList.addAll(result)
                    setIsLoading(false)
                }, {
                    setIsLoading(false)
                    Toast.makeText(App.instance.applicationContext,
                            App.instance.applicationContext.getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
                }))
    }
}

