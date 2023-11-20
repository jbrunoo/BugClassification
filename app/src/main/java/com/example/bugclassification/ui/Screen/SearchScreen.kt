package com.example.bugclassification.ui.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun SearchResultsDialog(onDismiss: () -> Unit) {
    val search_word by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = {
            // 다이얼로그 닫기
            onDismiss.invoke()
        },
        title = { Text("검색 결과") },
        text = {
            // 검색된 벌레 정보 표시
            Text("ddddd", modifier = Modifier.padding(16.dp))
        },
        confirmButton = {
            Button(
                onClick = {
                    // 확인 작업 수행
                    onDismiss.invoke()
                }
            ) {
                Text("확인")
            }
        }
    )
}

// "ant"에 대한 정보를 검색하는 함수
fun getBugInfo(bugName: String): String {
    // 실제로 검색을 수행하고 결과를 반환하도록 수정
    return when (bugName) {
        "ant" -> "개미는 작은 곤충입니다."
        "spider" -> "거미는 징그러운 곤충입니다."
        "butterfly" -> "나비는 아름다운 곤충입니다."
        else -> "검색된 벌레 정보가 없습니다."
    }
}

@Composable
fun SearchScreen(navController: NavController) {
    var isDialogVisible by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var bugInfo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "벌레 백과사전 검색",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = name,
            onValueChange = { name = it },
            label = {
                Text(text = "검색어를 입력하세요", fontSize = 16.sp)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        DialogButton(
            onClick = {
                // 사용자가 입력한 검색어에 대한 정보 가져오기
                bugInfo = getBugInfo(name)
                isDialogVisible = true
            },
            text = "검색하기",
            icon = Icons.Default.Search
        )

        if (isDialogVisible) {
            SearchResultsDialog(
                bugInfo = bugInfo,
                onDismiss = {
                    isDialogVisible = false
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

    }

//    MyScaffold(navController = navController) {
//        Column(
//            modifier = Modifier
//                .padding(it)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
////            OutlinedTextField(value = search_word, onValueChange = )
//            LazyColumn(modifier = Modifier.padding(it)) {
//
//            }
//        }
//    }
}

@Composable
fun DialogButton(
    onClick: () -> Unit,
    text: String,
    icon: ImageVector
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Black
        )
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun SearchResultsDialog(bugInfo: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            // 다이얼로그 닫기
            onDismiss.invoke()
        },
        title = { Text("검색 결과") },
        text = {
            // 검색된 벌레 정보 표시
            Text(bugInfo, modifier = Modifier.padding(16.dp))
        },
        confirmButton = {
            Button(
                onClick = {
                    // 확인 작업 수행
                    onDismiss.invoke()
                }
            ) {
                Text("확인")
            }
        }
    )
}