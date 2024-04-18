package com.example.shayariapp.Data.data_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AllShayariCategory")
class AllShayariCategory(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    var name: String?,
    var id: Int?

)