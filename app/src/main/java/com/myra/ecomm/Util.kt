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

}