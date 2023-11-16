package com.example.bugclassification.ui.Screen

import android.graphics.Bitmap
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.ui.Navigation.Screen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun InferenceScreen(navController: NavController) {
    val bitmap = remember {
        navController.previousBackStackEntry?.savedStateHandle?.get<Bitmap>("bitmap")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            modifier = Modifier.size(250.dp),
            imageModel = { bitmap }, // loading a network image using an URL.
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )
        // 추론된 정확도 값 표시
        Text(text = "정확도 : {~~%}")
        // main에서 사용자가 입력한 image
        Text(text = "title : {벌레 종류}") // 추론된 벌레 종류 받기
        Text(text = "{벌레 이름}") // 추론된 벌레 이름 받기
        // 추론된 결과 값 받아 firebase에 넣어둔 벌레 detail 정보 값 가져오기
        Text(
            text = "상세보기",
            modifier = Modifier.clickable { navController.navigate(Screen.Detail.route) },
        )

        // 벌레종류나 벌레이름 결과 값 받아 firebase에 넣어둔 벌레 image 파일 가져오기
        Text(text = "갤러리 :")
        Row() {
            Card {

            }
            Card {

            }
            Card {

            }
            Card {

            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        BottomRow(navController)
    }
}