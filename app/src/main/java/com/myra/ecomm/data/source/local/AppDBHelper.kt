package com.myra.ecomm.data.source.local

import com.myra.ecomm.data.source.model.db.*
import io.reactivex.Flowable
import io.reactivex.Maybe
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vikrambhati on 23/11/17.
 */
@Singleton
class AppDBHelper: DBHelper {

    val appDatabase: AppDatabase

    @Inject
    constructor(database: AppDatabase) {
        this.appDatabase = database
    }

    override fun insertCategoriesInDB(categoryList: List<Category>) {
        appDatabase.categoryDao().insertAllCategories(categoryList)
    }

    override fun getAllCategoriesFromDB(): Maybe<List<Category>> {
        return Maybe.just(appDatabase.categoryDao().getAllCategories())
    }

    override fun getAllProductsFromDB(categoryId: Int): Maybe<List<Product>> {
        return Maybe.just(appDatabase.productDao().getAllProducts(categoryId))
    }

    override fun getProductDetailFromDB(productId: Int): Maybe<Product> {
        return Maybe.just(appDatabase.productDao().getProductDetail(productId))
    }

    override fun getSimilarProductsWithGivenCategoryIdFromDB(categoryId: Int, productId: Int): Maybe<List<Product>> {
        return Maybe.just(appDatabase.productDao().getSimilarProductsWithGivenCategoryId(categoryId, productId))
    }

    override fun insertAllProductsInDB(productList: List<Product>) {
        appDatabase.productDao().insertAllProducts(productList)
    }

    override fun insertOrderedRankingInDB(orderedRankingList: List<OrderedRanking>) {
        appDatabase.rankingDao().insertAllOrderedRanking(orderedRankingList)
    }

    override fun insertSharedRankingInDB(sharedRankingList: List<SharedRanking>) {
        appDatabase.rankingDao().insertAllSharedRanking(sharedRankingList)
    }

    override fun insertViewedRankingInDB(viewedRankingList: List<ViewedRanking>) {
        appDatabase.rankingDao().insertAllViewedRanking(viewedRankingList)
    }

    override fun getOrderedRanking(): Maybe<List<OrderedRanking>> {
        return Maybe.just(appDatabase.rankingDao().getOrderedRanking())
    }

    override fun getSharedRanking(): Maybe<List<SharedRanking>> {
        return Maybe.just(appDatabase.rankingDao().getSharedRanking())
    }

    override fun getViewedRanking(): Maybe<List<ViewedRanking>> {
        return Maybe.just(appDatabase.rankingDao().getViewedRanking())
    }

}