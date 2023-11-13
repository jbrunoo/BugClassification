package com.example.bugclassification.ui.Screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun UserScreen(navController: NavController) {
    MyScaffold(navController = navController) {
        Text(text = "User Screen")
    }
}