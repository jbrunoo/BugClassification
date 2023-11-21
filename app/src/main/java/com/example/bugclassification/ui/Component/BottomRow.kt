package com.example.bugclassification.ui.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bugclassification.Navigation.Screen

@Composable
fun BottomRow(navController: NavController, bugType: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xDFE8ECEB))
            .padding(start = 4.dp, end = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "살충 방법 및 방역 업체 확인", fontWeight = FontWeight.ExtraBold, fontSize = 10.sp)
            Text(
                text = "해당 벌레 상세 살충 방법 및 방역 업체 확인",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 8.sp,
            )
        }

        Box(modifier = Modifier.padding(4.dp)) {
            Button(
                onClick = { navController.navigate(Screen.Product.route + "/${bugType}") },
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7AC239),
                    contentColor = Color.White
                )
            ) {
                Text(text = "더 알아보기!")
            }
        }
    }
}