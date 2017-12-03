package com.myra.ecomm.data.source.local.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myra.ecomm.data.source.model.db.OrderedRanking
import com.myra.ecomm.data.source.model.db.SharedRanking
import com.myra.ecomm.data.source.model.db.ViewedRanking

/**
 * Created by vikrambhati on 03/12/17.
 */
@Dao
interface RankingDAO {

    @Query("SELECT * FROM ordered_ranking ORDER BY order_count DESC")
    fun getOrderedRanking(): List<OrderedRanking>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllOrderedRanking(orderedRanking: List<OrderedRanking>) : Unit

    @Query("SELECT * FROM shared_ranking ORDER BY shares DESC ")
    fun getSharedRanking(): List<SharedRanking>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSharedRanking(sharedRanking: List<SharedRanking>) : Unit

    @Query("SELECT * FROM viewed_ranking ORDER BY view_count DESC")
    fun getViewedRanking(): List<ViewedRanking>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllViewedRanking(viewedRanking: List<ViewedRanking>) : Unit

}