package com.example.bugclassification.ui.Screen

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bugclassification.Navigation.Screen
import com.example.bugclassification.data.BugRepository
import com.example.bugclassification.data.Inference
import com.example.bugclassification.network.ApiManager
import com.example.bugclassification.ui.Component.LoadingAnimation
import com.example.bugclassification.ui.Component.MyScaffold
import com.example.bugclassification.ui.Component.bitmapToUri
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream

@Composable
fun MainScreen(navController: NavController, bugRepository: BugRepository) {
    val apiManager = ApiManager()

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var pred: Pair<String?, Int?> by remember {
        mutableStateOf(Pair("null", 0))
    }
    var loading by remember { mutableStateOf(false) }
    var selectUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var takenPhoto by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher = // 갤러리 이미지 런쳐
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = { uri ->
                if (uri != null) {
                    selectUri = uri
                    takenPhoto = null
                }
            }
        )
    val cameraLauncher = // 카메라 이미지 런쳐
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview(),
            onResult = { photo ->
                if (photo != null) {
                    takenPhoto = photo
                    selectUri = bitmapToUri(context, takenPhoto!!)
                }
            })

    val selectBitmap: Bitmap? =
        selectUri?.let { uriToBitmap(it, context) } ?: takenPhoto // 화면 넘어가면 구성변경 되서 null 됨.


    if (loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.align(Alignment.Center)) {
                LoadingAnimation(Modifier.fillMaxSize())
            }
        }

    } else {
        MyScaffold(navController = navController,
            content = {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (selectBitmap != null) { // vm에는 저장되어 있으나 이미지 표시 안하려고 selectBitmap은 화면 넘어가면(구성변경시) null
                            GlideImage(
                                modifier = Modifier.size(250.dp),
                                imageModel = { selectBitmap }, // loading a network image using an URL.
                                imageOptions = ImageOptions(
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center
                                )
                            )
                        } else {
                            Image(
                                imageVector = Icons.Outlined.PhotoCamera, contentDescription = null,
                                modifier = Modifier
                                    .size(200.dp)
                                    .fillMaxSize(),
                                colorFilter = ColorFilter.tint(Color(0xFF7AC239))
                            )
                        }
                        Text(
                            text = "해충을 찍어주세요!",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF7AC239)
                        )
                        Text(
                            text = "최대한 조심히 가까이 찍어주세요.",
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF7AC239)
                        )
                        Text(
                            text ="도망가지 않게",
                            fontWeight = FontWeight.Light,
                            color = Color(0xFF7AC239)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            OutlinedButton(
                                border = BorderStroke(1.dp, Color(0xFF7AC239)),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = Color.White,
                                    contentColor = Color(0xFF7AC239)
                                ),
                                onClick = {
                                    launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                                },
                            ) {
                                Icon(imageVector = Icons.Outlined.Image, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "이미지")
                            }
                            Spacer(modifier = Modifier.width(48.dp))
                            Button(
                                onClick = {
                                    // 기본 카메라 앱 실행
                                    cameraLauncher.launch(null)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF7AC239),
                                    contentColor = Color.White
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.PhotoCamera,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "갤러리")
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter,
                    ) {
                        Button(
                            onClick = {
                                if (selectUri != null) {
                                    val imageUri = selectUri.toString()
                                    loading = true
                                    scope.launch {
                                        pred = apiManager.uploadImage(
                                            context,
                                            Uri.parse(imageUri)
                                        )
                                        if (pred.first != null && pred.second != null) {
                                            bugRepository.insertInferenceInfo(
                                                Inference(
                                                    imageUri = imageUri,
                                                    bugType = pred.first,
                                                    accuracy = pred.second
                                                )
                                            )
                                            navController.navigate(Screen.Inference.route + "/${pred.first}")
                                            loading = false
                                        }
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF7AC239),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "분석", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            })
    }
}

fun uriToBitmap(uri: Uri, context: Context): Bitmap? {
    var inputStream: InputStream? = null
    return try {
        inputStream = context.contentResolver.openInputStream(uri)
        BitmapFactory.decodeStream(inputStream)
    } catch (e: IOException) {
        // IOException 처리 (예: 파일을 찾을 수 없음, 스트림을 열 수 없음 등)
        e.printStackTrace()
        null
    } finally {
        inputStream?.close()
    }
}
