package com.myra.ecomm.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.myra.ecomm.App
import com.myra.ecomm.Util
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.di.component.DaggerViewHolderComponent
import com.myra.ecomm.di.component.ViewHolderComponent

/**
 * Created by vikrambhati on 28/11/17.
 */
abstract class BaseViewHolder<T : ViewDataBinding, V : BaseViewModel<*>?> : RecyclerView.ViewHolder   {

    val view: View

    lateinit var binding: T

    var viewModel: V ? = null

    var viewHolderComponent: ViewHolderComponent? = null

    var dataManager: DataManager ? = null

    constructor(itemView: View) : super(itemView) {
        this.view = itemView
    }

    protected fun viewHolderComponent(): ViewHolderComponent {
        if (viewHolderComponent == null) {
            viewHolderComponent = DaggerViewHolderComponent.builder()
                    .appComponent(App.instance.appComponent)
                    .build()
        }

        dataManager = App.instance.appComponent.getDataManager()

        return viewHolderComponent!!
    }


}