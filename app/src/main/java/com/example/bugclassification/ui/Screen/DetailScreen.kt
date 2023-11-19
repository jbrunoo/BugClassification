package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bugclassification.data.Bug
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.data.Inference
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.ui.Component.MyScaffold
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(navController: NavController, bugType: String?, bugRepository: BugRepository) {
    val scope = rememberCoroutineScope()
    var bug: Bug? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        scope.launch {
            bug = bugRepository.getBugInfoByType(bugType = bugType.orEmpty())
        }
    }

    // 상세보기 눌렀을 때 나오는 값 가져와서 firebase에 저장된 detail 한 정보들 출력
    MyScaffold(navController = navController) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "{벌레 이름 중앙}")
            Text(text = "{벌레 이름 왼쪽}")
            Text(text = "{설명 ex) 서식지, 출몰 정보 등}")
            Text(text = "{퇴치방법}")
            BottomRow(navController)
        }
    }
}