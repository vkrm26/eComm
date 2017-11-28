package com.myra.ecomm.data.source.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by vikrambhati on 24/11/17.
 */
class VariantResponse {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("color")
    @Expose
    var color: String? = null
    @SerializedName("size")
    @Expose
    var size: Any? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null

}