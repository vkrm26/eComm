package com.myra.ecomm.data.source.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by vikrambhati on 24/11/17.
 */
class TaxResponse {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("value")
    @Expose
    var value: Float? = null

}
