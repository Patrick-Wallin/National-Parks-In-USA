package com.pwmobiledeveloper.nationalparksinusa.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pwmobiledeveloper.nationalparksinusa.model.*

@Dao
interface ParksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPark(park: TableParks) : Long

    fun insertAllParks(parks: List<ParkWithAllInfo>) {
        parks.forEach {
            val park_id = insertPark(it.park)
            if(park_id > 0) {
                /*
                if(!it.addresses.isEmpty()) {
                    for (address in it.addresses) {
                        address.park_id = park_id
                    }
                    insertAllAddress(it.addresses)
                }
                if(!it.phoneNumbers.isEmpty()) {
                    for (phoneNumber in it.phoneNumbers) {
                        phoneNumber.park_id = park_id
                    }
                    insertAllPhoneNumbers(it.phoneNumbers)
                }
                if(!it.activities.isEmpty()) {
                    for (activity in it.activities) {
                        activity.park_id = park_id
                    }
                    insertAllActivities(it.activities)
                }
                if(!it.entranceFees.isEmpty()) {
                    for (entranceFee in it.entranceFees) {
                        entranceFee.park_id = park_id
                    }
                    insertAllEntranceFees(it.entranceFees)
                }
                if(!it.entrancePasses.isEmpty()) {
                    for(entrancePass in it.entrancePasses) {
                        entrancePass.park_id = park_id
                    }
                    insertAllEntrancePasses(it.entrancePasses)
                }
                if(!it.operatingHours.isEmpty()) {
                    for(operatingHour in it.operatingHours) {
                        operatingHour.park_id = park_id
                    }
                    insertAllOperatingHour(it.operatingHours)
                }
                if(!it.exceptions.isEmpty()) {
                    for(exception in it.exceptions) {
                        exception.park_id = park_id
                    }
                    insertAllExceptions(it.exceptions)
                }
                if(!it.topics.isEmpty()) {
                    for(topic in it.topics) {
                        topic.park_id = park_id
                    }
                    insertAllTopics(it.topics)
                }
                if(!it.images.isEmpty()) {
                    for(image in it.images) {
                        image.park_id = park_id
                    }
                    insertAllImages(it.images)
                }
                if(!it.emailAddresses.isEmpty()) {
                    for(emailAddress in it.emailAddresses) {
                        emailAddress.park_id = park_id
                    }
                    insertAllEmailAddresses(it.emailAddresses)
                }

                 */
            }
        }
    }

    @Update
    fun updatePark(park: TableParks)

    @Query("DELETE FROM parks")
    fun clearParks()

    @Query("SELECT * FROM parks ORDER BY name")
    fun getAllParks(): LiveData<List<TableParks>>

    @Transaction
    @Query("SELECT * FROM parks ORDER BY name")
    fun getParksWithAddresses(): LiveData<List<ParkWithAddresses>>

    // Begin - Address
    @Insert
    fun insertAddress(address: TableAddress)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAddress(addresses: List<TableAddress>)

    @Update
    fun updateAddress(address: TableAddress)

    @Query("DELETE FROM addresses")
    fun clearAddresses()

    @Query("SELECT * FROM addresses WHERE park_id = :parkId")
    fun getAddresses(parkId: Long): TableAddress?
    // End - Address

    // Begin - Phone Numbers
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoneNumber(phoneNumber: TablePhoneNumber)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPhoneNumbers(phoneNumbers: List<TablePhoneNumber>)

    @Update
    fun updatePhoneNumber(phoneNumber: TablePhoneNumber)

    @Query("DELETE FROM phone_numbers")
    fun clearPhoneNumbers()

    @Query("SELECT * FROM phone_numbers WHERE park_id = :parkId")
    fun getPhoneNumbers(parkId: Long): TablePhoneNumber?
    // End - Phone Numbers

    // Begin - Activity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivity(activity: TableActivity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActivities(activity: List<TableActivity>)

    @Update
    fun updateActivity(activity: TableActivity)

    @Query("DELETE FROM activities")
    fun clearActivities()

    @Query("SELECT * FROM activities WHERE park_id = :parkId")
    fun getActivities(parkId: Long): TableActivity?
    // End - Activity

    // Begin - Entrance Fee
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntranceFee(entranceFee: TableEntranceFee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEntranceFees(entranceFees: List<TableEntranceFee>)

    @Update
    fun updateEntranceFee(entranceFee: TableEntranceFee)

    @Query("DELETE FROM entrancefees")
    fun clearEntranceFees()

    @Query("SELECT * FROM entrancefees WHERE park_id = :parkId")
    fun getEntranceFees(parkId: Long): TableEntranceFee?
    // End - Entrance Fee

    // Begin - Entrance Pass
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntrancePass(entrancePass: TableEntrancePass)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEntrancePasses(entrancePass: List<TableEntrancePass>)

    @Update
    fun updateEntrancePass(entrancePass: TableEntrancePass)

    @Query("DELETE FROM entrancepasses")
    fun clearEntrancePasses()

    @Query("SELECT * FROM entrancepasses WHERE park_id = :parkId")
    fun getEntrancePasses(parkId: Long): TableEntrancePass?
    // End - Entrance Pass

    // Begin - Operating Hours
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOperatingHour(operatingHour: TableOperatingHour)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllOperatingHour(operatingHour: List<TableOperatingHour>)

    @Update
    fun updateOperatingHour(operatingHour: TableOperatingHour)

    @Query("DELETE FROM operatinghours")
    fun clearOperatingHours()

    @Query("SELECT * FROM operatinghours WHERE park_id = :parkId")
    fun getOperatingHours(parkId: Long): TableOperatingHour?
    // End - Operating Hours

    // Begin - Exception
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertException(exception: TableException)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllExceptions(exceptions: List<TableException>)

    @Update
    fun updateException(exception: TableException)

    @Query("DELETE FROM exceptions")
    fun clearExceptions()

    @Query("SELECT * FROM exceptions WHERE park_id = :parkId")
    fun getExceptions(parkId: Long): TableException?
    // End - Exception

    // Begin - Topic
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopic(topic: TableTopic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTopics(topics: List<TableTopic>)

    @Update
    fun updateTopic(topic: TableTopic)

    @Query("DELETE FROM topics")
    fun clearTopics()

    @Query("SELECT * FROM topics WHERE park_id = :parkId")
    fun getTopics(parkId: Long): TableTopic?
    // End - Topic

    // Begin - Image
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImage(image: TableImage)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(image: List<TableImage>)

    @Update
    fun updateImage(image: TableImage)

    @Query("DELETE FROM images")
    fun clearImages()

    @Query("SELECT * FROM images WHERE park_id = :parkId")
    fun getImages(parkId: Long): TableImage?
    // End - Image

    // Begin - Email Address
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmailAddress(emailAddress: TableEmailAddress)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEmailAddresses(emailAddresses: List<TableEmailAddress>)

    @Update
    fun updateEmailAddress(emailAddress: TableEmailAddress)

    @Query("DELETE FROM email_addresses")
    fun clearEmailAddresses()

    @Query("SELECT * FROM email_addresses WHERE park_id = :parkId")
    fun getEmailAddresses(parkId: Long): TableEmailAddress?
    // End - Email Address
}

