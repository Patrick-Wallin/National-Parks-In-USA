package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TablePhoneNumber

@Dao
interface PhoneNumbersDao {
    @Insert
    fun insert(phoneNumber: TablePhoneNumber) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(phoneNumbers: List<TablePhoneNumber>) {

    }

    @Update
    fun update(phoneNumber: TablePhoneNumber)

    @Query("DELETE FROM phone_numbers")
    fun clear()

    @Query("SELECT * FROM phone_numbers WHERE park_id = :parkId")
    fun getPhoneNumbers(parkId: Long): TablePhoneNumber?
}