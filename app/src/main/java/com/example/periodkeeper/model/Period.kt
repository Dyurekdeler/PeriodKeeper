package com.example.periodkeeper.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Period(@PrimaryKey(autoGenerate = true)
                    val id: Int?,
                    val date:String,
                    val time:String? = null)
