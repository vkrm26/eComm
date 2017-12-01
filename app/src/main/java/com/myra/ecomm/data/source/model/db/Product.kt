package com.myra.ecomm.data.source.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.myra.ecomm.data.source.model.TaxInfo
import com.myra.ecomm.data.source.model.VariantInfo

/**
 * Created by vikrambhati on 23/11/17.
 */
@Entity(tableName = "product")
class Product() : Parcelable {

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

    constructor(parcel: Parcel) : this() {
        productId = parcel.readInt()
        categoryId = parcel.readInt()
        productName = parcel.readString()
        dataAdded = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(productId)
        parcel.writeValue(categoryId)
        parcel.writeString(productName)
        parcel.writeString(dataAdded)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}