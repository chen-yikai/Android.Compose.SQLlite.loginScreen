package com.example.androidcomposesqlliteloginscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun Home(nav: NavHostController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Home")
    }
}
