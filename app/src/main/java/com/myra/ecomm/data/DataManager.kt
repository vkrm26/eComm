package com.myra.ecomm.data

import com.myra.ecomm.data.source.local.DBHelper
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.data.source.remote.ApiHelper
import io.reactivex.Maybe

/**
 * Created by vikrambhati on 23/11/17.
 */
interface DataManager: ApiHelper, DBHelper {

    fun getAllCategory() : Maybe<List<Category>>

    fun getAllProductFromGivenCategory(categoryId: Int) : Maybe<List<Product>>

    fun getAllSimilarProducts(categoryId: Int, productId: Int) : Maybe<List<Product>>

    fun getAllProductByRanking(type: Int) : Maybe<List<Product>>

}