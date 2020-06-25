package com.example.periodkeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase
import com.example.periodkeeper.model.Period
import kotlinx.android.synthetic.main.fragment_add_period.*
import java.text.SimpleDateFormat
import java.util.*

class AddPeriodFragment : Fragment() {

    private var db: AppDatabase? = null
    private var periodDao: PeriodDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        db = AppDatabase.getAppDataBase(context = requireContext())
        periodDao = db?.periodDao()
        return inflater.inflate(R.layout.fragment_add_period, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        addPeriodTodayBtn.setOnClickListener {

            periodDao?.insertPeriod(Period(null, currentDate))
        }

        addPeriodCustomBtn.setOnClickListener {
            val dateGiven = periodDate.text.toString()
            if(dateGiven.isNotEmpty())
                periodDao?.insertPeriod(Period(null, dateGiven ))
        }
    }

}
