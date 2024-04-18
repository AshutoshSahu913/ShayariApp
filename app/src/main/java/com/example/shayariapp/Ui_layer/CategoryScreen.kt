package com.example.shayariapp.Ui_layer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shayariapp.R
import com.example.shayariapp.ui.theme.appColor

@Composable
fun CategoryScreen(navController: NavController, viewModel: ShayariViewModel) {
    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 10.dp, topStart = 10.dp
                        )
                    ),

                colors = CardDefaults.cardColors(
                    containerColor = Color.Black, contentColor = Color.White
                )

            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                ) {
                    Text(
                        text = "All Shayari",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )

                }
            }

        }

    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(viewModel.shayariCategoryList) {
                Box(
                    modifier = Modifier
                        .height(70.dp)
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(5.dp)
                        )
                        .background(appColor)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("ShayariScreen" + "/${it.id}")
                            }.padding(bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.love_svgrepo_com),
                            contentDescription = null,
                            alignment = Alignment.Center,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = it.name.toString(),
                            color = Color.White,
                            fontSize = 25.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Medium
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .padding(end=10.dp)
                        )
                    }
                }
            }
        }
    }
}