package com.example.bugclassification.Navigation

sealed class SettingScreen(val route: String){
    object SlideMenu : SettingScreen("silde_menu")
    object BugList : SettingScreen("bug_list")
    object UserProfile : SettingScreen("user_profile")
    object UserSettings : SettingScreen("user_settings")
    object CustomerInq : SettingScreen("customer_inquiries")
}
