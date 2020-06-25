package com.example.gotraveling.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gotraveling.Dao.PeriodDao
import com.example.periodkeeper.model.Period

@Database(entities = [Period::class],version =2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun periodDao(): PeriodDao


    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "MyPeriodDatabase").allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}