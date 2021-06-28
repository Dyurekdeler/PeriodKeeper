package com.example.periodkeeper.viewmodel

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase
import com.example.periodkeeper.model.Period
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.android.synthetic.main.fragment_add_period.*

@HiltViewModel
class WelcomeViewModel() : ViewModel() {

}
