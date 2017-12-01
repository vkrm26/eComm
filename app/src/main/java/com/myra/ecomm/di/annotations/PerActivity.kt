package com.myra.ecomm.di.annotations

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by vikrambhati on 29/11/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity