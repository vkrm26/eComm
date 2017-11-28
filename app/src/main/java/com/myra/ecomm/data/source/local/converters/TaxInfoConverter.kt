package com.myra.ecomm.data.source.local.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myra.ecomm.data.source.model.TaxInfo

/**
 * Created by vikrambhati on 26/11/17.
 */
class TaxInfoConverter {

    @TypeConverter
    fun fromString(value: String): TaxInfo {
        val listType = object : TypeToken<TaxInfo>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromTaxInfo(taxInfo: TaxInfo): String {
        val gson = Gson()
        val json = gson.toJson(taxInfo)
        return json
    }

}