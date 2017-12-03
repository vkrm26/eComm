package com.myra.ecomm.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.myra.ecomm.App
import com.myra.ecomm.BR
import com.myra.ecomm.R
import com.myra.ecomm.databinding.ActivityMainBinding
import com.myra.ecomm.di.component.ActivityComponent
import com.myra.ecomm.di.component.DaggerMainActivityComponent
import com.myra.ecomm.ui.base.BaseActivity
import com.myra.ecomm.ui.main.adapter.CategoryAdapter
import com.myra.ecomm.ui.productDetail.ProductDetailActivity
import javax.inject.Inject
import android.R.menu
import android.view.MenuInflater
import com.myra.ecomm.ui.ranking.ProductRankingActivity


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var mActivityMainBinding: ActivityMainBinding

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    @Inject
    lateinit var categoryAdapter: CategoryAdapter

    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerMainActivityComponent
                .builder()
                .appComponent(App.instance.appComponent)
                .build()
                .injectMainActivity(this)


        super.onCreate(savedInstanceState)


        mActivityMainBinding = viewDataBinding!!
        viewModel.setNavigator(this)
        setup()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.getItemId()) {
            R.id.most_viewed -> {
                var intent = Intent(this, ProductRankingActivity::class.java)
                startActivity(intent)
            }
            R.id.most_ordered -> {
            }
            R.id.most_shared -> {
            }
        }
        return true
    }

    private fun setup() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        mActivityMainBinding.blogRecyclerView.setLayoutManager(mLayoutManager)
        mActivityMainBinding.blogRecyclerView.setItemAnimator(DefaultItemAnimator())
        mActivityMainBinding.blogRecyclerView.setAdapter(categoryAdapter)
    }

    override fun openProductDetailActivity() {
        var openDetailIntent = Intent(this, ProductDetailActivity::class.java)
        startActivity(openDetailIntent)
    }

    override fun handleError(throwable: Throwable) {
        
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    
    
    override val layoutId: Int
        get() = R.layout.activity_main


    override val viewModel : MainViewModel
        get() {
            mainViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
            return mainViewModel!!
        }
}
