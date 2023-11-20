package com.example.bugclassification

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.airbnb.lottie.LottieAnimationView
import com.example.bugclassification.Navigation.Navigator
import com.example.bugclassification.ui.theme.BugClassificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 스플래시 화면 설정
        setContentView(R.layout.splash_screen_layout)

        // Lottie 애니메이션 뷰 찾기 및 설정
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieAnimationView)
        lottieAnimationView.setAnimation(R.raw.animation)
        lottieAnimationView.playAnimation()

        Handler(mainLooper).postDelayed({
        setContent {
            BugClassificationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator()
                }
            }
        }
        }, 3000)
    }
}
