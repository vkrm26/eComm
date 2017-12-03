package com.myra.ecomm.data.source.local

import com.myra.ecomm.data.source.model.db.*
import io.reactivex.Maybe

/**
 * Created by vikrambhati on 23/11/17.
 */
interface DBHelper {

    fun insertCategoriesInDB(categoryList: List<Category>): Unit

    fun getAllCategoriesFromDB(): Maybe<List<Category>>

    fun getAllProductsFromDB(categoryId: Int): Maybe<List<Product>>

    fun getProductDetailFromDB(productId: Int): Maybe<Product>

    fun getSimilarProductsWithGivenCategoryIdFromDB(categoryId: Int, productId: Int): Maybe<List<Product>>

    fun insertAllProductsInDB(productList: List<Product>): Unit

    fun insertOrderedRankingInDB(orderedRankingList: List<OrderedRanking>): Unit

    fun insertSharedRankingInDB(sharedRankingList: List<SharedRanking>): Unit

    fun insertViewedRankingInDB(viewedRankingList: List<ViewedRanking>): Unit

    fun getOrderedRanking(): Maybe<List<OrderedRanking>>

    fun getSharedRanking(): Maybe<List<SharedRanking>>

    fun getViewedRanking(): Maybe<List<ViewedRanking>>

}