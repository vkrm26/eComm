package com.myra.ecomm.ui.navigator

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity

/**
 * Created by vikrambhati on 29/11/17.
 */
class ActivityNavigator(appActivity: AppCompatActivity) : Navigator {

    var activity = appActivity

    override fun startActivity(intent: Intent) {
        activity.startActivity(intent)
    }
}