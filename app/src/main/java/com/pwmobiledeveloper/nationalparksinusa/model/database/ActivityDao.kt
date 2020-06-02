package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableActivity

@Dao
interface ActivityDao {
    @Insert
    fun insert(activity: TableActivity) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(activity: List<TableActivity>) {

    }

    @Update
    fun update(activity: TableActivity)

    @Query("DELETE FROM activities")
    fun clear()

    @Query("SELECT * FROM activities WHERE park_id = :parkId")
    fun getActivities(parkId: Long): TableActivity?
}