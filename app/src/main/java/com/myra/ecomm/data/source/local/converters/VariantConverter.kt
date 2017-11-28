package com.myra.ecomm.data.source.local.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myra.ecomm.data.source.model.VariantInfo
import java.util.ArrayList

/**
 * Created by vikrambhati on 26/11/17.
 */
class VariantConverter {

    @TypeConverter
    fun fromString(value: String): ArrayList<VariantInfo> {
        val listType = object : TypeToken<ArrayList<VariantInfo>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromVariantInfo(list: ArrayList<VariantInfo>): String {
        val gson = Gson()
        val json = gson.toJson(list)
        return json
    }

}