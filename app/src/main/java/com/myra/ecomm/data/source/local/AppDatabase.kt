package com.myra.ecomm.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.myra.ecomm.data.source.local.converters.TaxInfoConverter
import com.myra.ecomm.data.source.local.converters.VariantConverter
import com.myra.ecomm.data.source.local.db.CategoryDAO
import com.myra.ecomm.data.source.local.db.ProductDAO
import com.myra.ecomm.data.source.model.db.Category
import com.myra.ecomm.data.source.model.db.Product

/**
 * Created by vikrambhati on 23/11/17.
 */
@Database(entities = arrayOf(Category::class, Product::class), version = 1)
@TypeConverters(TaxInfoConverter::class, VariantConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDAO

    abstract fun productDao(): ProductDAO

}