package com.example.bugclassification.ui.Screen.SlideMenuScreen

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserProfileScreen() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 프로필 이미지
        if (profileImageUri != null) {
            GlideImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                imageModel = { profileImageUri }, // loading a network image using an URL.
//                imageOptions = ImageOptions(
//                    contentScale = ContentScale.Crop,
//                    alignment = Alignment.Center
//                )
            )
        } else {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // 이미지 업로드 버튼
        Button(
            onClick = {
                // 이미지 선택 및 업로드 로직
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7AC239) // 버튼의 배경색을 RGB(122, 194, 57)로 설정
            )
        ) {
            Text("프로필 이미지 변경")
        }

        // 사용자 정보 필드
        Text(text = "사용자 프로필 설정", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("사용자 이름") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("이메일 주소") })
        Spacer(modifier = Modifier.height(16.dp))

        // 프로필 업데이트 버튼
        Button(
            onClick = { /* 프로필 업데이트 로직 */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF7AC239) // 버튼의 배경색을 RGB(122, 194, 57)로 설정
            )
        ) {
            Text("프로필 업데이트")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Divider()

        // 로그인/로그아웃 링크
        TextButton(onClick = { /* 로그인/로그아웃 로직 */ }) {
            Text("로그아웃")
        }
    }
}

