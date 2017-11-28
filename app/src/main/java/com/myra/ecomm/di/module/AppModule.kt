package com.myra.ecomm.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.myra.ecomm.AppConstants
import com.myra.ecomm.data.AppDataManager
import com.myra.ecomm.data.DataManager
import com.myra.ecomm.data.source.local.AppDBHelper
import com.myra.ecomm.data.source.local.AppDatabase
import com.myra.ecomm.data.source.local.DBHelper
import com.myra.ecomm.data.source.remote.ApiHelper
import com.myra.ecomm.data.source.remote.AppApiHelper
import com.myra.ecomm.di.DatabaseInfo
import com.myra.ecomm.ui.main.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vikrambhati on 24/11/17.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDBHelper): DBHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

}