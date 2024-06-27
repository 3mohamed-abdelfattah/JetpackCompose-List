package com.example.jetpackcompose_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose_list.response.SimpleData
import com.example.jetpackcompose_list.ui.theme.JetpackComposeListTheme
import com.example.jetpackcompose_list.view.SimpleList
import com.example.jetpackcompose_list.view.SimpleListDetail
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeListTheme {
                NavigatePage()
            }
        }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sample_data") {
        composable("sample_data") { SimpleList(navController = navController) }
        composable(
            "simple_detail/{item}",
            arguments = listOf(navArgument("item") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry?.arguments?.getString("item")
                ?.let { json ->
                    val item = Gson().fromJson(json, SimpleData::class.java)
                    SimpleListDetail(data = item)
                }
        }

    }
}