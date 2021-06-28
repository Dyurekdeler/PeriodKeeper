package com.example.periodkeeper.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase

class AddPeriodViewModel : ViewModel() {
    private var db: AppDatabase? = null
    private var periodDao: PeriodDao? = null
}
