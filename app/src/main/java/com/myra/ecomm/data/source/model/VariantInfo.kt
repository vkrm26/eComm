package com.myra.ecomm.data.source.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by vikrambhati on 26/11/17.
 */
class VariantInfo() : Parcelable {

    var id: Int = 0
    var color: String = ""
    var size: String = ""
    var price: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        color = parcel.readString()
        size = parcel.readString()
        price = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(color)
        parcel.writeString(size)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VariantInfo> {
        override fun createFromParcel(parcel: Parcel): VariantInfo {
            return VariantInfo(parcel)
        }

        override fun newArray(size: Int): Array<VariantInfo?> {
            return arrayOfNulls(size)
        }
    }

}