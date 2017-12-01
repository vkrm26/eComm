package com.myra.ecomm.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.myra.ecomm.di.annotations.PerActivity
import com.myra.ecomm.ui.navigator.ActivityNavigator
import com.myra.ecomm.ui.navigator.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by vikrambhati on 29/11/17.
 */
@Module
class ActivityModule {

    var mActivity : AppCompatActivity

    @Inject
    constructor(activity: AppCompatActivity) {
        this.mActivity = activity
    }


    @Provides
    @PerActivity
    fun provideNavigator(): Navigator {
        return ActivityNavigator(mActivity)
    }


}