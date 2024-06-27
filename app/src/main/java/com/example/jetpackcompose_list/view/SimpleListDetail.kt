package com.example.jetpackcompose_list.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_list.R
import com.example.jetpackcompose_list.response.SimpleData

@Composable
fun SimpleListDetail(data: SimpleData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color(0x0C00000)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {}

        Spacer(modifier = Modifier.padding(20.dp))

        Image(
            painterResource(R.drawable.jetpack),
            contentDescription = "Image",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = data.name,
            color = Color.Black,
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = data.description,
            color = Color.DarkGray,
            fontSize = 25.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center,
            lineHeight = 35.sp
        )
    }
}