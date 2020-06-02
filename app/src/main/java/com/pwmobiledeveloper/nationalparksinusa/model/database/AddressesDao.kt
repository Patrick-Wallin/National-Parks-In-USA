package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.TableAddress

@Dao
interface AddressesDao {
    @Insert
    fun insert(address: TableAddress) {

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(addresses: List<TableAddress>) {

    }

    @Update
    fun update(address: TableAddress)

    @Query("DELETE FROM addresses")
    fun clear()

    @Query("SELECT * FROM addresses WHERE park_id = :parkId")
    fun getAddresses(parkId: Long): TableAddress?
}