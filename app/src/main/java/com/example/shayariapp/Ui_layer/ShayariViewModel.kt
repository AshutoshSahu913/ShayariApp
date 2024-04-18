package com.example.shayariapp.Ui_layer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.shayariapp.Data.ShayariRepo
import com.example.shayariapp.Data.data_models.AllShayari
import com.example.shayariapp.Data.data_models.AllShayariCategory

class ShayariViewModel(application: Application) : AndroidViewModel(application = application) {
    var sharyariRepo: ShayariRepo

    var shayariCategoryList = mutableListOf<AllShayariCategory>()

    init {
        sharyariRepo = ShayariRepo(application)
        shayariCategoryList.addAll(sharyariRepo.getAllShayariCategory())
    }
    fun getShayariByCategory(catId: Int): List<AllShayari> {
        return sharyariRepo.getShayariByCategory(catId)
    }
}