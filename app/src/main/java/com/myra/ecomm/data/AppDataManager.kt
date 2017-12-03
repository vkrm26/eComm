package com.myra.ecomm.data

import android.util.Log
import com.myra.ecomm.AppConstants
import com.myra.ecomm.data.source.local.DBHelper
import com.myra.ecomm.data.source.model.TaxInfo
import com.myra.ecomm.data.source.model.VariantInfo
import com.myra.ecomm.data.source.model.api.ApiResponse
import com.myra.ecomm.data.source.model.db.*
import com.myra.ecomm.data.source.remote.ApiHelper
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by vikrambhati on 24/11/17.
 */
class AppDataManager: DataManager {

    val dbHelper: DBHelper
    val apiHelper: ApiHelper

    @Inject
    constructor(dbHelper: DBHelper, apiHelper: ApiHelper) {
        this.dbHelper = dbHelper
        this.apiHelper = apiHelper
    }

    override fun getDataFromServer(): Maybe<ApiResponse> {
        return apiHelper.getDataFromServer()
    }

    override fun insertCategoriesInDB(categoryList: List<Category>) {
        dbHelper.insertCategoriesInDB(categoryList)
    }

    override fun getAllCategoriesFromDB(): Maybe<List<Category>> {
        return dbHelper.getAllCategoriesFromDB().filter { result -> result.isNotEmpty() }
    }

    override fun getAllCategory(): Maybe<List<Category>> {
        var categoryFromDB = getAllCategoriesFromDB()
        var categoryFromServer = getCategoryFromServer()

        return Maybe.concat(categoryFromDB, categoryFromServer).firstElement()
    }

    fun getCategoryFromServer() : Maybe<List<Category>> {
        var response = getDataFromServer()
                .flatMap { result ->
//                    Log.d("vikram", "size - " + result.categories!!.size)
                    insertAllDataInDB(result)
                    getAllCategoriesFromDB()
                }

            response.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe( {
                result ->
//                Log.d("vikram", "size - " + result.size)
            }, { })

        return response
    }

    fun insertAllDataInDB(apiResponse: ApiResponse) {
        var categoryList = ArrayList<Category>()
        var productList =  ArrayList<Product>()
        var category: Category

        for (categoryResponse in apiResponse.categories!!) {
            category = Category()
            category.categoryId = categoryResponse.id!!
            category.categoryName = categoryResponse.name!!

            var product: Product
            for (productResponse in categoryResponse.products!!) {
                product = Product()
                product.categoryId = categoryResponse.id!!
                product.productId = productResponse.id!!
                product.dataAdded = productResponse.dateAdded!!
                product.productName = productResponse.name!!

                var variant: VariantInfo
                var variantInfoList = ArrayList<VariantInfo>()
                for (variantResponse in productResponse.variants!!) {
                    variant = VariantInfo()
                    variant.id = variantResponse.id as Int
                    variant.color = variantResponse.color as String
                    variant.price = variantResponse.price as Int
                    variant.size = if (variantResponse.size == null) "" else variantResponse.size as String

                    variantInfoList.add(variant)
                }

                product.variantInfo = variantInfoList

                var taxInfo = TaxInfo()
                taxInfo.name = productResponse.tax?.name!!
                taxInfo.value = productResponse.tax?.value!!
                product.taxInfo  = taxInfo

                productList.add(product)
            }

            if (productList.size > 0) {
                categoryList.add(category)
                insertAllProductsInDB(productList)
            }
            productList.clear()
        }

        insertCategoriesInDB(categoryList)
        categoryList.clear()
        productList.clear()

        var orderedRankingList = ArrayList<OrderedRanking>()
        var sharedRankingList = ArrayList<SharedRanking>()
        var viewedRankingList = ArrayList<ViewedRanking>()
        for (rankingResponse in apiResponse.rankings!!) {

            if ("Most Viewed Products".equals(rankingResponse.ranking)) {
                for (viewCountResponse in rankingResponse.products!!) {
                    var viewedRanking = ViewedRanking()
                    viewedRanking.id = viewCountResponse.id!!
                    viewedRanking.view_count = viewCountResponse.viewCount!!
                    viewedRankingList.add(viewedRanking)
                }
            } else if ("Most OrdeRed Products".equals(rankingResponse.ranking)) {
                for (viewCountResponse in rankingResponse.products!!) {
                    var orderedRanking = OrderedRanking()
                    orderedRanking.id = viewCountResponse.id!!
                    orderedRanking.order_count = viewCountResponse.orderCount!!
                    orderedRankingList.add(orderedRanking)
                }
            } else if ("Most ShaRed Products".equals(rankingResponse.ranking)) {
                for (viewCountResponse in rankingResponse.products!!) {
                    var sharedRanking = SharedRanking()
                    sharedRanking.id = viewCountResponse.id!!
                    sharedRanking.shares = viewCountResponse.shares!!
                    sharedRankingList.add(sharedRanking)
                }
            }
        }

        if (orderedRankingList.size > 0) {
            insertOrderedRankingInDB(orderedRankingList)
        }

        if (sharedRankingList.size > 0) {
            insertSharedRankingInDB(sharedRankingList)
        }

        if (viewedRankingList.size > 0) {
            insertViewedRankingInDB(viewedRankingList)
        }
    }

    override fun getAllProductsFromDB(categoryId: Int): Maybe<List<Product>> {
        return dbHelper.getAllProductsFromDB(categoryId)
    }

    override fun getAllProductFromGivenCategory(categoryId: Int): Maybe<List<Product>> {
        return dbHelper.getAllProductsFromDB(categoryId)
    }

    override fun getProductDetailFromDB(productId: Int): Maybe<Product> {
        return dbHelper.getProductDetailFromDB(productId)
    }

    override fun getSimilarProductsWithGivenCategoryIdFromDB(productId: Int, categoryId: Int): Maybe<List<Product>> {
        return dbHelper.getSimilarProductsWithGivenCategoryIdFromDB(productId, categoryId)
    }

    override fun insertAllProductsInDB(productList: List<Product>) {
        dbHelper.insertAllProductsInDB(productList)
    }

    override fun getAllSimilarProducts(categoryId: Int, productId: Int): Maybe<List<Product>> {
        return dbHelper.getSimilarProductsWithGivenCategoryIdFromDB(categoryId, productId)
    }

    override fun insertOrderedRankingInDB(orderedRankingList: List<OrderedRanking>) {
        return dbHelper.insertOrderedRankingInDB(orderedRankingList)
    }

    override fun insertSharedRankingInDB(sharedRankingList: List<SharedRanking>) {
        return dbHelper.insertSharedRankingInDB(sharedRankingList)
    }

    override fun insertViewedRankingInDB(viewedRankingList: List<ViewedRanking>) {
        return dbHelper.insertViewedRankingInDB(viewedRankingList)
    }

    override fun getOrderedRanking(): Maybe<List<OrderedRanking>> {
        return dbHelper.getOrderedRanking()
    }

    override fun getSharedRanking(): Maybe<List<SharedRanking>> {
        return dbHelper.getSharedRanking()
    }

    override fun getViewedRanking(): Maybe<List<ViewedRanking>> {
        return dbHelper.getViewedRanking()
    }

    override fun getAllProductByRanking(type: Int): Maybe<List<Product>> {
        when(type) {
            AppConstants.RANKING_BY_ORDER -> return getAllProductByOrderedRanking()
            AppConstants.RANKING_BY_SHARE -> return getAllProductBySharedRanking()
            AppConstants.RANKING_BY_VIEW -> return getAllProductByViewedRanking()
        }

        return Maybe.just(ArrayList<Product>())
    }

    fun getAllProductByOrderedRanking() : Maybe<List<Product>> {
        var response = getOrderedRanking().toObservable()
                .flatMapIterable { it }
                .flatMap { result -> getProductDetailFromDB(result.id).toObservable() }
                .toList()
                .toMaybe()


        response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    result -> Log.d("vikram", "products by ranking - " + result.size)
                })

        return response
    }

    fun getAllProductBySharedRanking(): Maybe<List<Product>> {
        var response = getSharedRanking().toObservable()
                .flatMapIterable { it }
                .flatMap { result -> getProductDetailFromDB(result.id).toObservable() }
                .toList()
                .toMaybe()


        response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    result -> Log.d("vikram", "products by ranking - " + result.size)
                })

        return response
    }

    fun getAllProductByViewedRanking(): Maybe<List<Product>> {
        var response = getViewedRanking().toObservable()
                .flatMapIterable { it }
                .flatMap { result -> getProductDetailFromDB(result.id).toObservable() }
                .toList()
                .toMaybe()


        response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    result -> Log.d("vikram", "products by ranking - " + result.size)
                })

        return response
    }

}