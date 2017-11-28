package com.myra.ecomm.data.source.remote

import android.util.Log
import com.myra.ecomm.data.source.model.api.ApiResponse
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vikrambhati on 24/11/17.
 */
@Singleton
class AppApiHelper: ApiHelper {

    @Inject
    constructor()

    override fun getDataFromServer(): Maybe<ApiResponse> {
        return RemoteApiService.create().getProductData()
    }

}