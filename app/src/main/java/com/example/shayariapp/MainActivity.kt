package com.example.shayariapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shayariapp.Ui_layer.CategoryScreen
import com.example.shayariapp.Ui_layer.ShayariScreen
import com.example.shayariapp.Ui_layer.ShayariViewModel
import com.example.shayariapp.ui.theme.ShayariAppTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: ShayariViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this@MainActivity)[ShayariViewModel::class.java]
        setContent {
            ShayariAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MyApp(paddingValues = it, viewModel)

                }
            }
        }
    }
}

@Composable
fun MyApp(paddingValues: PaddingValues, viewModel: ShayariViewModel) {
    Box(modifier = Modifier.padding(paddingValues)) {
//        CategoryScreen()
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "CategoryScreen") {

            composable(route = "CategoryScreen") {
                CategoryScreen(navController, viewModel)
            }
            composable(route = "ShayariScreen" + "/{id}") {
                val id = it.arguments?.getString("id")

                ShayariScreen(viewModel.getShayariByCategory(id!!.toInt()))
            }
        }
    }
}