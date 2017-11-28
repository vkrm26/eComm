package com.myra.ecomm.data.source.local.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myra.ecomm.data.source.model.db.Category

/**
 * Created by vikrambhati on 23/11/17.
 */
@Dao
interface CategoryDAO {

    @Query("SELECT * FROM category")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCategories(categoryList: List<Category>) : Unit

}