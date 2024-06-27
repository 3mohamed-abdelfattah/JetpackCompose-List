package com.example.jetpackcompose_list.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.navigation.NavController
import com.example.jetpackcompose_list.R
import com.example.jetpackcompose_list.response.SimpleData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun SimpleList(navController: NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "Data.json")
    val gson = Gson()
    val listSimpleData = object : TypeToken<List<SimpleData>>() {}.type
    val simpleData: List<SimpleData> = gson.fromJson(dataFileString, listSimpleData)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Simple List",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(simpleData) { data -> SampleDataListItem(data, navController) }
        }
    }
}

@Composable
fun SampleDataListItem(data: SimpleData, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                val itemVal = Gson().toJson(data)
                navController.navigate("simple_detail/$itemVal")
            }
            .padding(10.dp)
            .fillMaxSize(),
//        elevation = 5.dp
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Image(
                //Add Photo
                painterResource(R.drawable.baseline_cruelty_free_24),
                contentDescription = "Photo", modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = data.name, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = data.description, fontSize = 15.sp)
            }
        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}
