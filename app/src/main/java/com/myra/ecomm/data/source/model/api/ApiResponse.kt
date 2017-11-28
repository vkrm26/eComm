package com.myra.ecomm.data.source.model.api

import android.service.notification.NotificationListenerService.Ranking
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by vikrambhati on 24/11/17.
 */
class ApiResponse {

    @SerializedName("categories")
    @Expose
    var categories: List<CategoryResponse>? = null
    @SerializedName("rankings")
    @Expose
    var rankings: List<Ranking>? = null

}