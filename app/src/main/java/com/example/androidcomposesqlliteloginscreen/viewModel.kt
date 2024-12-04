package com.example.androidcomposesqlliteloginscreen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class userAuth : ViewModel() {
    var starterScreen = mutableStateOf("signin")
    fun changeStarterScreen(screen: String) {
        starterScreen.value = screen
    }
}