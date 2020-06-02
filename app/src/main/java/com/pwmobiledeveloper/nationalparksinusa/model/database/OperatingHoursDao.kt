package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableOperatingHour

@Dao
interface OperatingHoursDao {
    @Insert
    fun insert(operatingHour: TableOperatingHour) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(operatingHour: List<TableOperatingHour>) {

    }

    @Update
    fun update(operatingHour: TableOperatingHour)

    @Query("DELETE FROM operatinghours")
    fun clear()

    @Query("SELECT * FROM operatinghours WHERE park_id = :parkId")
    fun getOperatingHours(parkId: Long): TableOperatingHour?
}