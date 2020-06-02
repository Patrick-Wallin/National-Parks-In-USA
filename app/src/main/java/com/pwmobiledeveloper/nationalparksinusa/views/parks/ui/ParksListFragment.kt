package com.pwmobiledeveloper.nationalparksinusa.views.parks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pwmobiledeveloper.nationalparksinusa.R
import com.pwmobiledeveloper.nationalparksinusa.databinding.FragmentParksListBinding
import com.pwmobiledeveloper.nationalparksinusa.model.database.ParksDatabase
import com.pwmobiledeveloper.nationalparksinusa.viewmodels.parks.ParksViewModel
import com.pwmobiledeveloper.nationalparksinusa.viewmodels.parks.ParksViewModelFactory
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class ParksListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentParksListBinding>(inflater,
            R.layout.fragment_parks_list, container, false)

        Timber.d("onCreateView")

        val application = requireNotNull(this.activity).application

        //val dataSource = getDatabase(application).parksDao
        val viewModelFactory = ParksViewModelFactory(application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ParksViewModel::class.java)

        binding.parksViewModel = viewModel

        Timber.d("onCreateView - End")

        return binding.root
    }

}
