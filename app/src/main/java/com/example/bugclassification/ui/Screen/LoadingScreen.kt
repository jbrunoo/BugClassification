package com.example.bugclassification.ui.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.bugclassification.network.ApiManager
import com.example.bugclassification.ui.Navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.URLDecoder

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoadingScreen(navController: NavController, selectUri: String) {
    val coroutineScope = rememberCoroutineScope()
    val apiManager = ApiManager()
    // 맵핑한 함수에서 해당 데이터 클래스의 value값 가져와서 변수에 할당
    val context = LocalContext.current
    val selectedUri = URLDecoder.decode(selectUri, "UTF-8")

    var pred: Pair<String?, Int?> by remember {
        mutableStateOf(Pair("dd", 0))
    }

    Column {
        Text(text = "Loading...😂😂")
        Text(text = "${pred.first} ${pred.second}")
        Button(onClick = {
            if (selectedUri != null) {

                coroutineScope.launch {
                    pred = apiManager.uploadImage(context, Uri.parse(selectedUri))
                    if (pred.first != null && pred.second != null) {
                        navController.navigate(Screen.Inference.route + "/${pred.first}/${pred.second}") {
                            popUpTo(Screen.Loading.route) { inclusive = true }
                        }
                    }
                }
            }
        }) {
            Text(text = "한번만 예측되길")
        }
    }
}

