package com.myra.ecomm.data.source.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.myra.ecomm.data.source.model.TaxInfo
import com.myra.ecomm.data.source.model.VariantInfo

/**
 * Created by vikrambhati on 23/11/17.
 */
@Entity(tableName = "product")
class Product {

    @PrimaryKey
    var productId: Int = 0

    @ColumnInfo
    var categoryId: Int = 0

    @ColumnInfo
    var productName: String = ""

    @ColumnInfo
    var dataAdded: String = ""

    @ColumnInfo
    var variantInfo: ArrayList<VariantInfo> ? = null

    @ColumnInfo
    var taxInfo: TaxInfo ? = null

}