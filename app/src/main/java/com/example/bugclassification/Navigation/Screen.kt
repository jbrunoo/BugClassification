package com.example.bugclassification.Navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Search : Screen("search")
    object User : Screen("user")
    object Inference : Screen("inference/{bugType}")
    object Detail : Screen("Detail/{bugType}")
    object Product : Screen("product/{bugType}")
}
