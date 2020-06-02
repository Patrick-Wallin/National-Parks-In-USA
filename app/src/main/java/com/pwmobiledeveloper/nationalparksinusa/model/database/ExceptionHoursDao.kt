package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableExceptionHours

@Dao
interface ExceptionHoursDao {
    @Insert
    fun insert(exceptionHour: TableExceptionHours) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exceptionHours: List<TableExceptionHours>) {

    }

    @Update
    fun update(exceptionHour: TableExceptionHours)

    @Query("DELETE FROM exceptionhours")
    fun clear()

    @Query("SELECT * FROM exceptionhours WHERE exception_id = :exceptionId")
    fun getExceptions(exceptionId: Long): TableExceptionHours?

}