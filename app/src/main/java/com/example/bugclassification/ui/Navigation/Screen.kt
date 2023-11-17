package com.example.bugclassification.ui.Navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Search : Screen("search")
    object User : Screen("user")
    object Loading : Screen("loading/{encodedUri}")
    object Inference : Screen("inference/{predictedClass}/{confidence}")
    object Detail : Screen("Detail")
    object Product : Screen("product")
    object Company : Screen("company")
}
