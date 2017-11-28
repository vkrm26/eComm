package com.myra.ecomm.data.source.remote

import com.myra.ecomm.data.source.model.api.ApiResponse
import io.reactivex.Flowable
import io.reactivex.Maybe
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by vikrambhati on 24/11/17.
 */
interface RemoteApiService {

    @GET("/json")
    fun getProductData(): Maybe<ApiResponse>

    companion object Factory {
        fun create(): RemoteApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(EndPoints.GET_DATA_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(RemoteApiService::class.java)
        }
    }

}