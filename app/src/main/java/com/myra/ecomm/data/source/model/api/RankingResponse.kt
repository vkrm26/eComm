package com.myra.ecomm.data.source.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by vikrambhati on 24/11/17.
 */
class RankingResponse {

    @SerializedName("ranking")
    @Expose
    var ranking: String? = null
    @SerializedName("products")
    @Expose
    var products: List<ViewCountResponse>? = null

}