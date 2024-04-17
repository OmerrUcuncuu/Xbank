package com.example.baylok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xbank.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var girilenMiktar by remember {mutableStateOf("")}
                var bakiye by remember { mutableStateOf(1000) }
                Image(painter = painterResource(id = R.drawable.xbank),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(35.dp))

                Text(text = "XBank", color = Color.Blue, fontSize = 35.sp)

                Spacer(modifier = Modifier.height(35.dp))

                TextField(value = girilenMiktar,
                    onValueChange = {girilenMiktar = it},
                    placeholder = { Text(text = "Miktar girinişz")},
                    label = { Text(text = "Miktar")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(35.dp))

                OutlinedButton(
                    onClick = {
                        if (girilenMiktar.toInt() < bakiye){
                            bakiye -= girilenMiktar.toInt()
                        }
                    },
                    modifier = Modifier.width(290.dp),
                    shape = RoundedCornerShape(0.dp)
                )
                {
                    Text(text = "Para Çek")
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "")

                }

                Spacer(modifier = Modifier.height(35.dp))

                OutlinedButton(
                    onClick = {
                        if (girilenMiktar.toInt()>0){
                            bakiye += girilenMiktar.toInt()
                        }
                    },
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.width(290.dp)
                )
                {
                    Text(text = "Para Yatır")
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")

                }

                Spacer(modifier = Modifier.height(35.dp))

                Text(text = "${bakiye} TL", fontSize = 30.sp)
            }
        }
    }
}

