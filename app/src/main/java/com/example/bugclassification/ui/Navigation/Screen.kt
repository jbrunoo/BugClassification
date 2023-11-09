package com.example.bugclassification.ui.Navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Search : Screen("search")
    object User : Screen("user")
    object Inference : Screen("inference")
    object Detail : Screen("Detail")
    object Product : Screen("product")
    object Company : Screen("company")
}
