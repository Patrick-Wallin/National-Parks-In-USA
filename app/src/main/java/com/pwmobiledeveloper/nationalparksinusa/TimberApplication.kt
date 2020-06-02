package com.pwmobiledeveloper.nationalparksinusa

import android.app.Application
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDatabase
import com.pwmobiledeveloper.nationalparksinusa.model.database.getDatabase
import timber.log.Timber

class TimberApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = getDatabase(applicationContext)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: TimberApplication
        lateinit var database: ParksDatabase
    }
}