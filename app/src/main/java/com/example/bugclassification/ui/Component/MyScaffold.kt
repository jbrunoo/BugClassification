package com.example.bugclassification.ui.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bugclassification.ui.Navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "이 벌레 뭔가요?",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color(color = 0xDF1296FF)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
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
                        IconButton(onClick = { navController.navigate(Screen.Main.route) }) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = Icons.Outlined.Home, contentDescription = null,
                                tint = Color(color = 0xDF0D80DB)
                            )
                        }
                        IconButton(onClick = { navController.navigate(Screen.User.route) }) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = null,
                                tint = Color(color = 0xDF0D80DB)
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
}
