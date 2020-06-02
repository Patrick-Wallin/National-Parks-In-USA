package com.pwmobiledeveloper.nationalparksinusa.viewmodels.parks

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDao

class ParksViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParksViewModel::class.java)) {
            return ParksViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}