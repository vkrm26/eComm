package com.myra.ecomm.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.myra.ecomm.data.source.local.converters.TaxInfoConverter
import com.myra.ecomm.data.source.local.converters.VariantConverter
import com.myra.ecomm.data.source.local.db.CategoryDAO
import com.myra.ecomm.data.source.local.db.ProductDAO
import com.myra.ecomm.data.source.local.db.RankingDAO
import com.myra.ecomm.data.source.model.db.*

/**
 * Created by vikrambhati on 23/11/17.
 */
@Database(entities = arrayOf(Category::class, Product::class, OrderedRanking::class,
        SharedRanking::class, ViewedRanking::class), version = 1)
@TypeConverters(TaxInfoConverter::class, VariantConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDAO

    abstract fun productDao(): ProductDAO

    abstract fun rankingDao() : RankingDAO

}