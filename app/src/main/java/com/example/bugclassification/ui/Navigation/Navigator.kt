package com.example.bugclassification.ui.Navigation

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bugclassification.ui.Screen.CompanyScreen
import com.example.bugclassification.ui.Screen.DetailScreen
import com.example.bugclassification.ui.Screen.InferenceScreen
import com.example.bugclassification.ui.Screen.MainScreen
import com.example.bugclassification.ui.Screen.MainViewModel
import com.example.bugclassification.ui.Screen.ProductScreen
import com.example.bugclassification.ui.Screen.SearchScreen
import com.example.bugclassification.ui.Screen.UserScreen

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) { MainScreen(navController, mainViewModel = MainViewModel()) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.User.route) { UserScreen(navController) }
        composable(Screen.Inference.route) { InferenceScreen(navController) }
        composable(Screen.Detail.route) { DetailScreen(navController) }
        composable(Screen.Product.route) { ProductScreen(navController) }
        composable(Screen.Company.route) { CompanyScreen(navController) }
    }
}

