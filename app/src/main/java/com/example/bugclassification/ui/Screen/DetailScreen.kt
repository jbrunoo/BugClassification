package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun DetailScreen(navController: NavController) {
    // 상세보기 눌렀을 때 나오는 값 가져와서 firebase에 저장된 detail 한 정보들 출력
    MyScaffold(navController = navController) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "{벌레 이름 중앙}")
            Text(text = "{벌레 이름 왼쪽}")
            Text(text = "{설명 ex) 서식지, 출몰 정보 등}")
            Text(text = "{퇴치방법}")
            BottomRow()
        }
    }
}