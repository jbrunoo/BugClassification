package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bugclassification.Component.MyBox
import com.example.bugclassification.ui.Navigation.Screen

@Composable
fun InfenceScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
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
        MyBox()
    }
}
