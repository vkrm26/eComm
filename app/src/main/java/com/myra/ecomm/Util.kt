package com.myra.ecomm

import android.content.Context
import android.content.ContextWrapper

/**
 * Created by vikrambhati on 26/11/17.
 */
object Util {

    // Tries to cast an Activity Context to another type
    fun <T> castActivityFromContext(context: Context, castClass: Class<T>): T? {
        var context = context
        if (castClass.isInstance(context)) {
            return context as T
        }

        while (context is ContextWrapper) {
            context = context.baseContext

            if (castClass.isInstance(context)) {
                return context as T
            }
        }

        return null
    }

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

}