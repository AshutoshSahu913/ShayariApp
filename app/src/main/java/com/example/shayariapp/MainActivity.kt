package com.example.shayariapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import com.example.shayariapp.Ui_layer.CategoryScreen
import com.example.shayariapp.ui.theme.ShayariAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShayariAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MyApp(paddingValues = it)

                }
            }
        }
    }
}

@Composable
fun MyApp(paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        CategoryScreen()
        NavHost(navController = , graph =  ) {

        }
    }
}

