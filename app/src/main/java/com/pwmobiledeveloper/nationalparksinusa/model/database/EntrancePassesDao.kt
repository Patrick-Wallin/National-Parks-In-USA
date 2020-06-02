package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableEntrancePass

@Dao
interface EntrancePassesDao {
    @Insert
    fun insert(entrancePass: TableEntrancePass) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entrancePass: List<TableEntrancePass>) {

    }

    @Update
    fun update(entrancePass: TableEntrancePass)

    @Query("DELETE FROM entrancepasses")
    fun clear()

    @Query("SELECT * FROM entrancepasses WHERE park_id = :parkId")
    fun getEntrancePasses(parkId: Long): TableEntrancePass?
}