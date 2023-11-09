package com.example.bugclassification.ui.Navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("Detail")
    object Inference : Screen("inference")
    object Product : Screen("product")
    object Company : Screen("company")
}
