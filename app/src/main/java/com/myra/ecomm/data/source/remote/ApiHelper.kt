package com.myra.ecomm.data.source.remote

import com.myra.ecomm.data.source.model.api.ApiResponse
import io.reactivex.Maybe

/**
 * Created by vikrambhati on 24/11/17.
 */
interface ApiHelper {

    fun getDataFromServer() : Maybe<ApiResponse>

}