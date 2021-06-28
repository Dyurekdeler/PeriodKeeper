package com.example.periodkeeper.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat
import androidx.navigation.findNavController
import androidx.room.Room
import com.example.gotraveling.Dao.PeriodDao
import com.example.gotraveling.Database.AppDatabase
import com.example.periodkeeper.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar!!.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set btn click listeners to navigate
        addPeriodTab.setOnClickListener {
            goAddPeriod()
        }
    }

    private fun setDefaultBarIcons(){
        heartImg.setImageResource(R.drawable.heart)
    }

    fun goAddPeriod(){
        setDefaultBarIcons()
        heartImg.setImageResource(R.drawable.heart_blue)
        this.findNavController(R.id.fragment).navigate(R.id.addPeriodFragment)
    }
}
