package com.example.bugclassification.ui.Screen.SlideMenuScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserSettingsScreen() {
    var notificationsEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White), // 화이트 배경색 적용
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "알림 아이콘",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF7AC239)
        )
        Spacer(Modifier.height(8.dp))
        // '알림 설정' 텍스트
        Text(
            "알림 설정",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black // 텍스트 색상을 검은색으로 설정
        )
        Spacer(modifier = Modifier.height(20.dp))

        // 알림 활성화 스위치
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "알림 활성화",
                fontSize = 18.sp,
                modifier = Modifier.weight(1f),
                color = Color.Black // 텍스트 색상을 검은색으로 설정
            )
            Switch(
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF7AC239), // 스카이블루 색상 적용
                    checkedTrackColor = Color(0xFF7AC239).copy(alpha = 0.5f) // 스카이블루 색상 적용
                )
            )
        }
        if (notificationsEnabled) {
            Text(
                "알림이 활성화되었습니다.",
                fontSize = 16.sp,
            )
        } else {
            Text(
                "알림이 비활성화되었습니다.",
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        // 여기에 추가 설정 요소를 배치할 수 있습니다.
    }
}