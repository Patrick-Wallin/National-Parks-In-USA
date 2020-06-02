package com.pwmobiledeveloper.nationalparksinusa.viewmodels.parks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pwmobiledeveloper.nationalparksinusa.TimberApplication
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDatabase
import com.pwmobiledeveloper.nationalparksinusa.model.database.getDatabase
import com.pwmobiledeveloper.nationalparksinusa.model.repository.ParksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

enum class ParksApiStatus { LOADING, ERROR, DONE }

class ParksViewModel(application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main )

    private val _status = MutableLiveData<ParksApiStatus>()
    val status: LiveData<ParksApiStatus>
        get() = _status

    //private var instanceValue : ParksDatabase = getDatabase(application)

    private val parksRepository = ParksRepository(TimberApplication.database)
    //private val parksRepository = ParksRepository(getDatabase(application))

    val parkList = parksRepository.parks

    init {
        Timber.d("ParksViewModel-init")
       // val db = TimberApplication.database
       // val entityCount = db.parksDao.getAllParks()

       // Timber.d(entityCount.value.toString())
        /*
        if(instanceValue == null)
            Timber.d("is null")
        else
            Timber.d("not null")
*/
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        coroutineScope.launch {
            _status.value = ParksApiStatus.LOADING

            try {
                parksRepository.refreshParks()
                _status.value = ParksApiStatus.DONE
            } catch (networkError: Exception) {
                _status.value = ParksApiStatus.DONE
                Timber.d(networkError.message)
                if(parkList.value.isNullOrEmpty())
                    _status.value = ParksApiStatus.ERROR
            }
        }
    }

    override fun onCleared() {
        Timber.d("onCleared")

        super.onCleared()
        viewModelJob.cancel()
    }

    /*


    private val _parks = MutableLiveData<List<Parks>>()
    val parks: LiveData<List<Parks>>
        get() =_parks

    private val _navigateToSelectedPark = MutableLiveData<Parks>()
    val navigateToSelectedPark: LiveData<Parks>
        get() =  _navigateToSelectedPark



    init {
        getParks(ParksApiService.API_KEY)
    }

    private suspend fun getParks(api_key: String) {
        coroutineScope.launch {
            val getParks: List<Parks> = ParksApi.retrofitService.getParks(api_key)
            try {
                _status.value = ParksApiStatus.LOADING
                var listResult = getParks
                _status.value = ParksApiStatus.DONE
                _parks.value = listResult
            } catch (e: Exception) {
                _status.value = ParksApiStatus.ERROR
                _parks.value = ArrayList()
            }
        }

    }
    */
}