package com.example.bugclassification.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.bugclassification.ui.Navigation.Screen
import com.example.bugclassification.ui.Screen.ProductScreen

@Composable
fun MyBox() {
    val navController = rememberNavController()

    Row {
        Column {
            Text(text = "살충 방법 및 방역 업체 확인")
            Text(text = "해당 벌레 상세 살충 방법 및 방역 업체 확인")
        }
        Button(onClick = { navController.navigate(Screen.Product.route) },
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            )
        ) {
            Text(text = "더 알아보기!")
        }
    }
}