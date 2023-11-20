package com.example.bugclassification.ui.Screen.SlideMenuScreen

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CustomerInquiriesScreen() {
    val context = LocalContext.current
    val url = "https://polydactyl-room-9bf.notion.site/dbe82256dec24c5792c495083f500dad?pvs=4"

    Column(modifier = Modifier.padding(16.dp)) {
        // 아이콘과 '고객 문의' 타이틀
        Icon(
            imageVector = Icons.Default.Email, // 예시 아이콘, 원하는 아이콘으로 변경 가능
            contentDescription = "문의 아이콘",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF7AC239) // 아이콘 색상 설정
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "고객 문의",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // '노션에서 문의 보기' 버튼
        Button(
            onClick = {
                val customTabsIntent = CustomTabsIntent.Builder().build()
                customTabsIntent.launchUrl(context, Uri.parse(url))
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7AC239) // 버튼의 배경색을 RGB(122, 194, 57)로 설정
            )
        ) {
            Text("자주하는 질문")
        }
    }
}