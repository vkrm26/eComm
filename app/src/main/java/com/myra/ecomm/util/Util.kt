package com.myra.ecomm.util

import android.content.Context
import android.net.ConnectivityManager
import com.myra.ecomm.App
import com.myra.ecomm.R

/**
 * Created by vikrambhati on 26/11/17.
 */
object Util {

    fun getColor(colorStr: String) : Int {
        if ("Blue".equals(colorStr)) return R.color.Blue
        else if ("Red".equals(colorStr)) return R.color.Red
        else if ("Black".equals(colorStr)) return R.color.Black
        else if ("Grey".equals(colorStr)) return R.color.Grey
        else if ("White".equals(colorStr)) return R.color.White
        else if ("Yellow".equals(colorStr)) return R.color.Yellow
        else if ("Light Blue".equals(colorStr)) return R.color.Light_Blue
        else if ("Green".equals(colorStr)) return R.color.Green
        else if ("Brown".equals(colorStr)) return R.color.Brown
        else if ("Silver".equals(colorStr)) return R.color.Silver
        else if ("Golden".equals(colorStr)) return R.color.Golden
        else return R.color.defaultColor
    }

    fun isNetworkConnected(): Boolean {
        var context = App.instance.applicationContext
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

}