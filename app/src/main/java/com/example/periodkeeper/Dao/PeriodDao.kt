package com.example.gotraveling.Dao

import androidx.room.*
import com.example.periodkeeper.model.Period

@Dao
interface PeriodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeriod(period: Period)

    @Update
    fun updatePeriod(period: Period)

    @Delete
    fun deletePeriod(period: Period)

    @Query("SELECT * FROM Period WHERE id == :id")
    fun getPeriodById(id: String): List<Period>

    @Query("SELECT * FROM Period")
    fun getPeriods(): List<Period>

    @Query("SELECT * FROM Period WHERE id in (SELECT MAX(id) FROM Period)")
    fun getLastestPeriod(): List<Period>


}