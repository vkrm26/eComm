package com.myra.ecomm.data.source.local

import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSimilarProductsWithGivenCategoryIdFromDB(productId: Int, categoryId: Int): Maybe<List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertAllProductsInDB(productList: List<Product>) {
        appDatabase.productDao().insertAllProducts(productList)
    }

    val appDatabase: AppDatabase

    @Inject
    constructor(database: AppDatabase) {
        this.appDatabase = database
    }

}