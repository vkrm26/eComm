package com.myra.ecomm.data.source.local

import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import io.reactivex.Maybe

/**
 * Created by vikrambhati on 23/11/17.
 */
interface DBHelper {

    fun insertCategoriesInDB(categoryList: List<Category>): Unit

    fun getAllCategoriesFromDB(): Maybe<List<Category>>

    fun getAllProductsFromDB(categoryId: Int): Maybe<List<Product>>

    fun getProductDetailFromDB(productId: Int): Maybe<Product>

    fun getSimilarProductsWithGivenCategoryIdFromDB(productId: Int, categoryId: Int): Maybe<List<Product>>

    fun insertAllProductsInDB(productList: List<Product>): Unit

}