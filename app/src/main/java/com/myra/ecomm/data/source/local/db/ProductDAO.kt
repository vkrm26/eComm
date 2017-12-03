package com.myra.ecomm.data.source.local.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myra.ecomm.data.source.model.db.Product

/**
 * Created by vikrambhati on 23/11/17.
 */
@Dao
interface ProductDAO {

    @Query("SELECT * FROM product WHERE categoryId = :categoryId")
    fun getAllProducts(categoryId: Int): List<Product>

    @Query("SELECT * FROM product WHERE productId = :productId")
    fun getProductDetail(productId: Int): Product

    @Query("SELECT * FROM product WHERE categoryId = :categoryId AND NOT productId = :productId")
    fun getSimilarProductsWithGivenCategoryId(categoryId: Int, productId: Int): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProducts(productList: List<Product>): Unit
}