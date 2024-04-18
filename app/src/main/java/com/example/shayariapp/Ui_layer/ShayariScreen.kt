package com.example.shayariapp.Ui_layer

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shayariapp.Data.data_models.AllShayari
import com.example.shayariapp.R
import com.example.shayariapp.ui.theme.appColor

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun ShayariScreen(allShayariList: List<AllShayari>) {

    val context = LocalContext.current

    LazyColumn {
        items(allShayariList) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {


                Column(modifier = Modifier.background(appColor)) {

                    Text(
                        text = it.Shayari.toString(),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color.Black),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {


                        Icon(
                            painter = painterResource(id = R.drawable.copy_svgrepo_com),
                            contentDescription = "copy",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                val textToCopy = it.Shayari.toString()
                                val clipboardManager =
                                    context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                                val clipData = ClipData.newPlainText("text", textToCopy)
                                clipboardManager.setPrimaryClip(clipData)
                                Toast.makeText(
                                    context,
                                    "Text copied to clipboard",
                                    Toast.LENGTH_SHORT
                                ).show()
                            })


                        Icon(
                            painter = painterResource(id = R.drawable.whatsapp_whats_app_svgrepo_com__1_),
                            contentDescription = "whatsapp",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    val intent = Intent()
                                    intent.setAction(Intent.ACTION_SEND)
                                    intent.setType("text/plain")
                                    intent.putExtra(
                                        Intent.EXTRA_TEXT,
                                        it.Shayari.toString()
                                    )
                                    context.startActivity(intent)
                                }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.share_svgrepo_com),
                            contentDescription = "Share",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                val messageText = it.Shayari.toString()
                                val intent = Intent(Intent.ACTION_SENDTO).apply {
                                    data = Uri.parse("smsto:") // This is the Uri for sending SMS
                                    putExtra("sms_body", messageText)
                                }
                                context.startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}