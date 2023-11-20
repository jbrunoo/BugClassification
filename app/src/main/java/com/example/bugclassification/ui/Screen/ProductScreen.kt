package com.example.bugclassification.ui.Screen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.example.bugclassification.R
import com.example.bugclassification.data.ProductUrl
import com.example.bugclassification.ui.Component.MyScaffold

@Composable
fun ProductScreen(navController: NavController, bugType: String?) {
    val context = LocalContext.current
    // 웹 브라우저를 열기 위한 Intent 생성
    val productList = getProductsByBugType(bugType)

    MyScaffold(navController = navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bug_image), contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Text(text = "살충제 제품", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
            }
            if (bugType != null) {
                Text(text = bugType, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                productList.forEach { arg ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clickable {
                                OpenLinkInBrowser(context, arg.url)
                            },
                        colors = CardDefaults.cardColors(containerColor = Color(0xDF0D80DB))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(arg.product)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

fun getProductsByBugType(bugType: String?): List<ProductUrl> {
    // bugType에 따라 필요한 ProductUrl을 선택
    return when (bugType) {
        "개미" -> listOf(ProductUrl.ANT1, ProductUrl.ANT2, ProductUrl.ANT3)
        "거미" -> listOf(ProductUrl.SPIDER1, ProductUrl.SPIDER2, ProductUrl.SPIDER3)
        "권연벌레" -> listOf(
            ProductUrl.CIGAR_BEETLE1,
            ProductUrl.CIGAR_BEETLE2,
            ProductUrl.CIGAR_BEETLE3
        )

        "권연침벌" -> listOf(
            ProductUrl.CEPHALONOMIA_GALLICOLA1,
            ProductUrl.CEPHALONOMIA_GALLICOLA2,
            ProductUrl.CEPHALONOMIA_GALLICOLA3
        )

        "그리마" -> listOf(
            ProductUrl.HOUSE_CENTIPEDE1,
            ProductUrl.HOUSE_CENTIPEDE2,
            ProductUrl.HOUSE_CENTIPEDE3
        )

        "나방" -> listOf(ProductUrl.MOTH1, ProductUrl.MOTH2, ProductUrl.MOTH3)
        "나방파리" -> listOf(ProductUrl.MOTH_FLY1, ProductUrl.MOTH_FLY2, ProductUrl.MOTH_FLY3)
        "바구미" -> listOf(ProductUrl.WEEVIL1, ProductUrl.WEEVIL2, ProductUrl.WEEVIL3)
        "바퀴벌레" -> listOf(ProductUrl.COCKROACH1, ProductUrl.COCKROACH2, ProductUrl.COCKROACH3)
        "파리" -> listOf(ProductUrl.FLY1, ProductUrl.FLY2, ProductUrl.FLY3)
        "먼지다듬이" -> listOf(ProductUrl.BOOKLICE1, ProductUrl.BOOKLICE2, ProductUrl.BOOKLICE3)
        "모기" -> listOf(ProductUrl.MOSQUITO1, ProductUrl.MOSQUITO2, ProductUrl.MOSQUITO3)
        "빈대" -> listOf(ProductUrl.BED_BUG1, ProductUrl.BED_BUG2, ProductUrl.BED_BUG3)
        "좀벌레" -> listOf(ProductUrl.SILVERFISH1, ProductUrl.SILVERFISH2, ProductUrl.SILVERFISH3)
        "쥐며느리" -> listOf(ProductUrl.SOW_BUG1, ProductUrl.SOW_BUG2, ProductUrl.SOW_BUG3)
        "진드기" -> listOf(ProductUrl.MITE1, ProductUrl.MITE2, ProductUrl.MITE3)
        "집게벌레" -> listOf(ProductUrl.EARWIG1, ProductUrl.EARWIG2, ProductUrl.EARWIG3)
        else -> emptyList() // 예외 처리: 알 수 없는 bugType에 대한 경우 빈 리스트 반환
    }
}

fun OpenLinkInBrowser(context: Context, link: String) {
    val intent = Intent(Intent.ACTION_VIEW, link.toUri())
    ContextCompat.startActivity(context, intent, null)
}