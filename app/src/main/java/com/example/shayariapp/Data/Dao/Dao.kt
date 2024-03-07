package com.example.shayariapp.Data.Dao

import androidx.room.Dao
import androidx.room.Query
import com.example.shayariapp.Data.data_models.AllShayari
import com.example.shayariapp.Data.data_models.AllShayariCategory

@Dao
interface Dao {

    @Query("SELECT * FROM ALLSHAYARICATEGORY")
    fun getAllShayariCategory(): List<AllShayariCategory>

    @Query("SELECT * FROM AllShayari WHERE Cat_id =:cat_id ")
    fun getShayariByCategory(cat_id:Int):List<AllShayari>
}