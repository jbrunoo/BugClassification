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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bugclassification.ui.Component.MyScaffold
import com.example.bugclassification.ui.Component.saveBitmapToFile
import com.example.bugclassification.ui.Component.uploadImage
import com.example.bugclassification.ui.Navigation.Screen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = viewModel()) {
    val uiState by mainViewModel.uiState.collectAsState()

    val context = LocalContext.current
    val launcher = // 갤러리 이미지 런쳐
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = { uri ->
                mainViewModel.setBitmap(uri?.let { uriToBitmap(it, context) })
            }
        )
    val cameraLauncher = // 카메라 이미지 런쳐
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview(),
            onResult = { photo ->
                mainViewModel.setBitmap(photo)
            })
    val bitmap: Bitmap? = uiState.bitmap

    if(bitmap != null) {
        val imageFile = saveBitmapToFile(context, bitmap)
    }
    var respond : String? = "no"

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
                    if (uiState.bitmap != null) {
                        GlideImage(
                            modifier = Modifier.size(250.dp),
                            imageModel = { uiState.bitmap }, // loading a network image using an URL.
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
                            colorFilter = ColorFilter.tint(Color(0xDF0D80DB))
                        )
                    }
                    Text(
                        text = "해충을 찍어주세요!",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xDF0D80DB)
                    )
                    Text(
                        text = "최대한 조심히 가까이 찍어주세요. 도망가지 않게",
                        fontWeight = FontWeight.ExtraLight,
                        color = Color(0xDF0D80DB)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        OutlinedButton(
                            border = BorderStroke(1.dp, Color(0xDF0D80DB)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.White,
                                contentColor = Color(0xDF0D80DB)
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
                                containerColor = Color(0xDF0D80DB),
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
                    Row {
                        Button(
                            onClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    key = "bitmap",
                                    value = uiState.bitmap
                                )
                                navController.navigate(Screen.Inference.route)
                            },
                            enabled = uiState.bitmap != null
                        ) {
                            Text(text = "dddddd")
                        }
                        Button(onClick = {
                            if(bitmap != null){
                                GlobalScope.launch {
//                                    val result = uploadImage(imageF)
                                }

                            }
                        }) {
                            Text(text = "예측")
                        }
                        Text(text = "$respond")
                    }
                }
            }
        })
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
