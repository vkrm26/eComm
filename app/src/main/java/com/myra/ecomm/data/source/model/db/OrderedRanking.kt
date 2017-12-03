package com.myra.ecomm.data.source.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by vikrambhati on 03/12/17.
 */
@Entity(tableName = "ordered_ranking")
class OrderedRanking {

    @PrimaryKey
    var id: Int = 0

    @ColumnInfo
    var order_count: Int = 0

}