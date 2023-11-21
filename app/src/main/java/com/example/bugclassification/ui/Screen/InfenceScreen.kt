package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bugclassification.data.Bug
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.data.Inference
import com.example.bugclassification.ui.Component.BottomRow
import com.example.bugclassification.Navigation.Screen
import com.example.bugclassification.R
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

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, end = 16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(text = "정확도 : ${inference?.accuracy}%", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GlideImage(
                modifier = Modifier.size(250.dp),
                imageModel = { inference?.imageUri }, // loading a network image using an URL.
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "${bug?.bugTitle}", fontSize = 20.sp, fontWeight = FontWeight.Bold) // 추론된 벌레 종류 받기
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "\"   ${inference?.bugType}   \"", fontSize = 20.sp, fontWeight = FontWeight.Bold) // 추론된 벌레 이름 받기
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "▶ 상세보기 ▶",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate(Screen.Detail.route + "/${bugType}") },
            )
            Spacer(modifier = Modifier.height(20.dp))
            // 벌레종류나 벌레이름 결과 값 받아 firebase에 넣어둔 벌레 image 파일 가져오기
            Text(text = "갤러리", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.bedbug22), contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop)
                    }
                }
                item {
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.bedbug144), contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop)
                    }
                }
                item {
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.bedbug155), contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop)
                    }
                }
                item {
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Image(painter = painterResource(R.drawable.bedbug67), contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                                .background(Color.Gray),
                            contentScale = ContentScale.Crop)
                    }
                }

            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        BottomRow(navController, bugType)
    }

}
