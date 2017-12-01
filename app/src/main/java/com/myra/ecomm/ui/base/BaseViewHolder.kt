package com.myra.ecomm.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.myra.ecomm.App
import com.myra.ecomm.Util
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.di.component.ActivityComponent
import com.myra.ecomm.di.component.DaggerViewHolderComponent
import com.myra.ecomm.di.component.ViewHolderComponent
import com.myra.ecomm.ui.navigator.Navigator

/**
 * Created by vikrambhati on 28/11/17.
 */
abstract class BaseViewHolder<T : ViewDataBinding, V : BaseViewModel<Navigator>?> : RecyclerView.ViewHolder   {

    val view: View

    lateinit var binding: T

    var viewModel: V ? = null

    var viewHolderComponent: ViewHolderComponent? = null

    var activityComponent: ActivityComponent ? = null

    var dataManager: DataManager ? = null
//    var layoutManager: LinearLayoutManager ? = null

    constructor(itemView: View) : super(itemView) {
        this.view = itemView
    }

    protected fun viewHolderComponent(): ViewHolderComponent {
        if (viewHolderComponent == null) {
            activityComponent = Util.castActivityFromContext(view.context, BaseActivity::class.java)!!.activityComponent()

            viewHolderComponent = DaggerViewHolderComponent.builder()
                    .activityComponent(activityComponent)
                    .build()
        }

        dataManager = App.instance.appComponent.getDataManager()
//        layoutManager = activityComponent!!.layoutManager()

        return viewHolderComponent!!
    }




}