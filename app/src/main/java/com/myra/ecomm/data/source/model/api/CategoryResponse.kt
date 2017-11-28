package com.myra.ecomm.data.source.model.api

import com.myra.ecomm.data.source.model.db.Product
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by vikrambhati on 24/11/17.
 */
class CategoryResponse {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("products")
    @Expose
    var products: List<ProductResponse>? = null
    @SerializedName("child_categories")
    @Expose
    var childCategories: List<Int>? = null

}