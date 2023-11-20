package com.example.bugclassification.ui.Component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bugclassification.Navigation.Screen
import com.example.bugclassification.Navigation.SettingScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.border(0.5.dp, Color(color = 0xB281C5FC)),
                containerColor = Color.White,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = Icons.Outlined.Settings,
                                contentDescription = null,
                                tint = Color(color = 0xDF0D80DB)
                            )
                        }

                        IconButton(onClick = { navController.navigate(Screen.Main.route) }) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = Icons.Outlined.Home, contentDescription = null,
                                tint = Color(color = 0xDF0D80DB)
                            )
                        }

                        IconButton(onClick = {
                            navController.navigate(Screen.Search.route)
                        }) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = Icons.Outlined.ImportContacts,
                                contentDescription = null,
                                tint = Color(0xDF0D80DB)
                            )
                        }
                    }
                }
            )
        },
        content = { paddingValues ->
            content(paddingValues)
        }
    )
    AnimatedVisibility(
        visible = showMenu,
        enter = slideInHorizontally(
            // 화면 오른쪽에서 시작하여 화면 중앙까지만 이동
            initialOffsetX = { fullWidth -> fullWidth / 2 },
            animationSpec = tween(durationMillis = 500)
        ),
        exit = slideOutHorizontally(
            // 화면 중앙에서 시작하여 화면 오른쪽으로 이동
            targetOffsetX = { fullWidth -> fullWidth / 2 },
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        SlideMenuScreen(navController, showMenu)
    }
}

@Composable
fun SlideMenuScreen(navController: NavController, showMenu: Boolean) {
    // 슬라이드 메뉴의 현재 위치를 계산합니다.
    // 화면의 절반만큼만 이동하도록 설정합니다.
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val menuWidth = 200.dp
    val offsetX = animateDpAsState(
        targetValue = if (showMenu) screenWidth - menuWidth else screenWidth,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(menuWidth)
            .offset(x = offsetX.value)
            .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize() // 내부 박스 크기를 외부 박스와 동일하게 설정
                .padding(0.5.dp) // 테두리를 둘러싸도록 패딩 조정
                .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                .background(Color.White) // 내부 박스 배경색 설정
        )  {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // 클릭 가능한 텍스트 링크로 변경된 메뉴 항목
                MenuLink("벌레 목록", Icons.Default.List){
                    navController.navigate(SettingScreen.BugList.route)
                }
                MenuLink("프로필 설정", Icons.Default.Settings){
                    navController.navigate(SettingScreen.UserProfile.route)
                }
                MenuLink("알림 설정", Icons.Default.Notifications){
                    navController.navigate(SettingScreen.UserSettings.route)
                }
                MenuLink("고객 문의", Icons.Default.Email){
                    navController.navigate(SettingScreen.CustomerInq.route)
                }
            }
        }
    }
}

@Composable
fun MenuLink(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF7AC239) // 아이콘에 0xFF7AC239 색상 적용
        )
        Spacer(Modifier.width(16.dp)) // 고정된 너비의 Spacer로 아이콘과 텍스트 사이 간격 조정
        Text(
            text = text,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium), // 텍스트 스타일 조정
        )
    }
}