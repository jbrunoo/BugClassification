package com.example.bugclassification.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bugclassification.data.AppDatabase
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.ui.Screen.DetailScreen
import com.example.bugclassification.ui.Screen.InferenceScreen
import com.example.bugclassification.ui.Screen.MainScreen
import com.example.bugclassification.ui.Screen.ProductScreen
import com.example.bugclassification.ui.Screen.SearchScreen
import com.example.bugclassification.ui.Screen.UserScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Composable
fun Navigator() {
    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context, CoroutineScope(Dispatchers.IO))
    val bugRepository = BugRepository(db.bugInfoDao(), db.inferenceInfoDao())
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) { MainScreen(navController, bugRepository) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.User.route) { UserScreen(navController) }
        composable(Screen.Inference.route + "/{bugType}") {
            val bugType = it.arguments?.getString("bugType")
            InferenceScreen(navController, bugType, bugRepository)
        }
        composable(Screen.Detail.route + "/{bugType}") {
            val bugType = it.arguments?.getString("bugType")
            DetailScreen(navController, bugType, bugRepository)
        }
        composable(Screen.Product.route) { ProductScreen(navController) }
    }
}