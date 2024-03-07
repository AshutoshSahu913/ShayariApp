package com.example.shayariapp.Data.data_models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AllShayariCategory")
class AllShayariCategory(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("uid") var id: Int? = null,
    var name: String,
    @ColumnInfo("id") var CategoryId: Int

)