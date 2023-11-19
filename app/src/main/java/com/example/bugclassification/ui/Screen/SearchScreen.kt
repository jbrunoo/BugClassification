package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun SearchScreen(navController: NavController) {
    val search_word by remember {
        mutableStateOf("")
    }
    MyScaffold(navController = navController) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            OutlinedTextField(value = search_word, onValueChange = )
            LazyColumn(modifier = Modifier.padding(it)) {

            }
        }
    }
}