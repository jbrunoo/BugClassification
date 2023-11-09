package com.example.bugclassification.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bugclassification.ui.Screen.CompanyScreen
import com.example.bugclassification.ui.Screen.DetailScreen
import com.example.bugclassification.ui.Screen.InfenceScreen
import com.example.bugclassification.ui.Screen.MainScreen
import com.example.bugclassification.ui.Screen.ProductScreen

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route){
        composable(Screen.Main.route) { MainScreen(navController) }
        composable(Screen.Inference.route) { InfenceScreen(navController) }
        composable(Screen.Detail.route) { DetailScreen(navController) }
        composable(Screen.Product.route) { ProductScreen(navController) }
        composable(Screen.Company.route) { CompanyScreen(navController) }
    }
}

