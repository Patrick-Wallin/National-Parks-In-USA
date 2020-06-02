package com.pwmobiledeveloper.nationalparksinusa.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.pwmobiledeveloper.nationalparksinusa.model.DomainPark
import com.pwmobiledeveloper.nationalparksinusa.model.asDomainModel
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDao
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDatabase
import com.pwmobiledeveloper.nationalparksinusa.model.network.ParksApi
import com.pwmobiledeveloper.nationalparksinusa.model.network.ParksApiService
import com.pwmobiledeveloper.nationalparksinusa.model.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class ParksRepository(private val database: ParksDatabase) {
    //val parks: LiveData<List<DomainPark>> = Transformations.map(database.parksDao.getAllParks()) {
      //  it.asDomainModel()
    //}
    val parks = database.parksDao.getAllParks()

    init {
        Timber.d("Injection ParksRepository")
    }

    suspend fun refreshParks() {
        withContext(Dispatchers.IO) {
            Timber.d("refreshParks() is called")
            val parkList = ParksApi.retrofitService.getParks(ParksApiService.API_KEY,5)
            Timber.d(parkList.toString())
            //database.parksDao.insertAllParks(parkList.asDatabaseModel())
        }
    }



}