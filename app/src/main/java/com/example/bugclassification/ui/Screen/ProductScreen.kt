package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun ProductScreen(navController: NavController) {
    MyScaffold(navController = navController) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}
