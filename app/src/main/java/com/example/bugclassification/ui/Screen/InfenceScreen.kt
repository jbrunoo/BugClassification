package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bugclassification.data.Bug
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.data.Inference
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.Navigation.Screen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun InferenceScreen(navController: NavController, bugType: String?, bugRepository: BugRepository) {

    val scope = rememberCoroutineScope()
    var bug: Bug? by remember { mutableStateOf(null) }
    var inference: Inference? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        scope.launch {
            bug = bugRepository.getBugInfoByType(bugType = bugType.orEmpty())
            inference = bugRepository.getInferenceInfoByBugType(bugType = bugType.orEmpty())
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            modifier = Modifier.size(250.dp),
            imageModel = { inference?.imageUri }, // loading a network image using an URL.
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )
        // 추론된 정확도 값 표시
        Text(text = "정확도 : ${inference?.accuracy}")
        // main에서 사용자가 입력한 image
        Text(text = "title : ${bug?.bugTitle}") // 추론된 벌레 종류 받기
        Text(text = "${inference?.bugType}") // 추론된 벌레 이름 받기
        Text(
            text = "상세보기",
            modifier = Modifier.clickable { navController.navigate(Screen.Detail.route + "/{bugType}") },
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
