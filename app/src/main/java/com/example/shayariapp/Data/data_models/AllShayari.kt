package com.example.shayariapp.Data.data_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AllShayari")
class AllShayari(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("uid")
    var id: Int? = null,
    var Cat_id: Int?,
    var Shayari: String?

)