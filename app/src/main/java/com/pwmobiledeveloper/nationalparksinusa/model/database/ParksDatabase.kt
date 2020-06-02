package com.pwmobiledeveloper.nationalparksinusa.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pwmobiledeveloper.nationalparksinusa.model.*
import timber.log.Timber
/*
@Database(entities = [TableParks::class, TableActivity::class, TableAddress::class,
    TableEmailAddress::class, TableEntranceFee::class, TableEntrancePass::class, TableImage::class,
    TableTopic::class, TablePhoneNumber::class, TableOperatingHour::class,
    TableException::class], version = 1, exportSchema = false)
*/
@Database(entities = [TableParks::class,TableAddress::class, TableEmailAddress::class,
    TableException::class, TableOperatingHour::class, TablePhoneNumber::class,
    TableTopic::class, TableImage::class, TableEntrancePass::class, TableEntranceFee::class,
    TableActivity::class], version = 1, exportSchema = false)
abstract class ParksDatabase : RoomDatabase() {
    abstract val parksDao: ParksDao


    /*
    abstract val activityDao: ActivityDao
    abstract val addressesDao: AddressesDao
    abstract val emailAddressesDao: EmailAddressesDao
    abstract val entranceFeesDao: EntranceFeesDao
    abstract val entrancePassesDao: EntrancePassesDao
    abstract val imagesDao: ImagesDao
    abstract val topicsDao: TopicsDao
    abstract val phoneNumbersDao: PhoneNumbersDao
    abstract val operatingHoursDao: OperatingHoursDao
    abstract val exceptionsDao: ExceptionsDao

     */
}

private lateinit var INSTANCE: ParksDatabase

fun getDatabase(context: Context): ParksDatabase {
    synchronized(ParksDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ParksDatabase::class.java,
                "parks_database"
            ).fallbackToDestructiveMigration().build()

                //
            if(INSTANCE == null)
                Timber.d("INSTANCE is NULL")
            else
                Timber.d("INSTANCE IS NOT NULL!")
        }
    }

    return INSTANCE
}

private val CALLBACK = object : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        Timber.d("create database")
        //db.execSQL("INSERT CATEGORY (id, name) VALUES (1, \"TESTE\") ")
    }
}
