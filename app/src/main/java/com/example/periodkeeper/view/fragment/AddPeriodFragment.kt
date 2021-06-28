package com.example.periodkeeper.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.room.Room
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase
import com.example.periodkeeper.R
import com.example.periodkeeper.model.Period
import com.example.periodkeeper.view.activity.MainActivity
import com.example.periodkeeper.viewmodel.AddPeriodViewModel
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
            Toast.makeText(context, "Added today period: " + currentDate.toString(), Toast.LENGTH_LONG).show()
        }

        addPeriodCustomBtn.setOnClickListener {
            val dateGiven = periodDate.text.toString()
            if(dateGiven.isNotEmpty()) {
                periodDao?.insertPeriod(Period(null, dateGiven))
                Toast.makeText(
                    context,
                    "Added custom period: " + dateGiven,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}
