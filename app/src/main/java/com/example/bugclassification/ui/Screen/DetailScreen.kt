package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bugclassification.data.Bug
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.data.Inference
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.ui.Component.MyScaffold
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun DetailScreen(navController: NavController, bugType: String?, bugRepository: BugRepository) {
    val scope = rememberCoroutineScope()
    var bug: Bug? by remember { mutableStateOf(null) }
    var inference: Inference? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        scope.launch {
            bug = bugRepository.getBugInfoByType(bugType = bugType.orEmpty())
            inference = bugRepository.getInferenceInfoByBugType(bugType = bugType.orEmpty())
        }
    }

    // 상세보기 눌렀을 때 나오는 값 가져와서 firebase에 저장된 detail 한 정보들 출력
    MyScaffold(navController = navController) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                GlideImage(
                    modifier = Modifier.size(250.dp),
                    imageModel = { inference?.imageUri }, // loading a network image using an URL.
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
            item {
                Card(
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = bug?.bugType ?: "no-data",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "종", fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = bug?.bugTitle ?: "no-data",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "정보", fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = bug?.bugInfo ?: "no-data")
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "서식지", fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = bug?.bugHab ?: "no-data")
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "예방 방법", fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = bug?.bugPrev ?: "no-data")
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "퇴치 방법", fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = bug?.bugExt ?: "no-data")
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            contentAlignment = Alignment.BottomCenter,
        ) {
            BottomRow(navController, bugType)
        }
    }
}