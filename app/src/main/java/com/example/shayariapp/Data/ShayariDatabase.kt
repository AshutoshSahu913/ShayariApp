package com.example.shayariapp.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shayariapp.Data.Dao.Dao
import com.example.shayariapp.Data.data_models.AllShayari
import com.example.shayariapp.Data.data_models.AllShayariCategory

@Database(
    entities = arrayOf(AllShayariCategory::class, AllShayari::class),
    version = 1,
    exportSchema = true
)
abstract class ShayariDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        fun DbBuilder(context: Context): ShayariDatabase {
            return Room.databaseBuilder(
                context, ShayariDatabase::class.java, "Shayari.db"
            ).createFromAsset("Shayari.db").build()
        }
    }
}
