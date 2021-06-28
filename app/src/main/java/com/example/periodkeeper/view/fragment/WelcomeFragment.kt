package com.example.periodkeeper.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase
import com.example.periodkeeper.R
import kotlinx.android.synthetic.main.fragment_welcome.*
import java.text.SimpleDateFormat
import java.util.*

class WelcomeFragment : Fragment() {

    private var db: AppDatabase? = null
    private var periodDao: PeriodDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        db = AppDatabase.getAppDataBase(context = requireContext())
        periodDao = db?.periodDao()
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(periodDao?.getPeriods()?.isNotEmpty()!!){

            val latestPeriod = periodDao?.getLastestPeriod()
            if (latestPeriod != null) {
                val period = latestPeriod.get(0)
                lastPeriodDate.text = period.date

                val sdf = SimpleDateFormat("dd/M/yyyy")

                val cal = Calendar.getInstance()
                cal.time = sdf.parse(period.date)
                val msDiff: Long = Calendar.getInstance().getTimeInMillis() - cal.getTimeInMillis()
                val daysDiff: Long = java.util.concurrent.TimeUnit.MILLISECONDS.toDays(msDiff)

                daysPast.text = daysDiff.toString()
            }
        }
        else{
            lastPeriodDate.text = "No Date"
            daysPast.text = "No Days"
        }


        super.onViewCreated(view, savedInstanceState)
    }



}
