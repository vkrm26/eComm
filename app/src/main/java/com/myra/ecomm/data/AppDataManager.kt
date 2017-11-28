package com.myra.ecomm.data

import android.util.Log
import com.myra.ecomm.data.source.local.DBHelper
import com.myra.ecomm.data.source.model.TaxInfo
import com.myra.ecomm.data.source.model.VariantInfo
import com.myra.ecomm.data.source.model.api.ApiResponse
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product
import com.myra.ecomm.data.source.remote.ApiHelper
import io.reactivex.Maybe
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
        return dbHelper.getAllCategoriesFromDB()
    }

    override fun getAllCategory(): Maybe<List<Category>> {
        var categoryFromDB = getAllCategoriesFromDB()
        var categoryFromServer = getCategoryFromServer()

        return Maybe.concat(categoryFromDB, categoryFromServer).firstElement()

    }

    fun getCategoryFromServer() : Maybe<List<Category>> {
        var response = getDataFromServer()
                .flatMap { result ->
                    Log.d("vikram", "size - " + result.categories!!.size)
                    insertAllDataInDB(result)
                    getAllCategoriesFromDB()
                }

            response.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe( {
                result ->
                Log.d("vikram", "size - " + result.size)
        })

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
                    variant.id = variantResponse!!.id
                    variant.color = variantResponse!!.color
                    variant.price = variantResponse!!.price
                    variant.size = variantResponse!!.size

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


}