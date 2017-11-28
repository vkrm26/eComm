package com.myra.ecomm.data.source.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by vikrambhati on 23/11/17.
 */
@Entity(tableName = "category")
class Category {

    @PrimaryKey
    var categoryId: Int = 0

    @ColumnInfo
    var categoryName: String = ""
}