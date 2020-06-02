package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableEmailAddress

@Dao
interface EmailAddressesDao {
    @Insert
    fun insert(emailAddress: TableEmailAddress) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(emailAddresses: List<TableEmailAddress>) {

    }

    @Update
    fun update(emailAddress: TableEmailAddress)

    @Query("DELETE FROM email_addresses")
    fun clear()

    @Query("SELECT * FROM email_addresses WHERE park_id = :parkId")
    fun getEmailAddresses(parkId: Long): TableEmailAddress?
}