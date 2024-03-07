package com.example.shayariapp.Data

import android.content.Context
import com.example.shayariapp.Data.data_models.AllShayari
import com.example.shayariapp.Data.data_models.AllShayariCategory

class ShayariRepo(context: Context) {

    lateinit var database: ShayariDatabase

    init {

        database = ShayariDatabase.DbBuilder(context = context)
    }

    fun getAllShayariCategory(): List<AllShayariCategory> {
        return database.dao().getAllShayariCategory()
    }

    fun getShayariByCategory(cat_id: Int): List<AllShayari> {
        return database.dao().getShayariByCategory(cat_id)
    }
}