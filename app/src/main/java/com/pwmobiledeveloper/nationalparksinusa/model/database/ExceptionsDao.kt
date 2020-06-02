package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableException

@Dao
interface ExceptionsDao {
    @Insert
    fun insert(exception: TableException) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exceptions: List<TableException>) {

    }

    @Update
    fun update(exception: TableException)

    @Query("DELETE FROM exceptions")
    fun clear()

    @Query("SELECT * FROM exceptions WHERE park_id = :parkId")
    fun getExceptions(parkId: Long): TableException?
}