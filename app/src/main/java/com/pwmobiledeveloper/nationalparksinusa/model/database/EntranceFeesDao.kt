package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableEntranceFee

@Dao
interface EntranceFeesDao {
    @Insert
    fun insert(entranceFee: TableEntranceFee) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entranceFees: List<TableEntranceFee>) {

    }

    @Update
    fun update(entranceFee: TableEntranceFee)

    @Query("DELETE FROM entrancefees")
    fun clear()

    @Query("SELECT * FROM entrancefees WHERE park_id = :parkId")
    fun getEntranceFees(parkId: Long): TableEntranceFee?
}