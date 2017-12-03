package com.myra.ecomm.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import com.myra.ecomm.ui.navigator.Navigator

/**
 * Created by vikrambhati on 28/11/17.
 */
abstract class BaseViewHolder<T : ViewDataBinding, V : BaseViewModel<Navigator>?> : RecyclerView.ViewHolder   {

    val view: View

    lateinit var binding: T

    var viewModel: V ? = null

    constructor(itemView: View) : super(itemView) {
        this.view = itemView
    }

}