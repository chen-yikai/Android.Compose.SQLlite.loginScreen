package com.example.androidcomposesqlliteloginscreen

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposesqlliteloginscreen.ui.theme.AndroidComposeSQLliteloginScreenTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    LogIn()
}

@Composable
fun LogIn() {
    val context = LocalContext.current
    val dbHandler = DBHandler(context)
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Text("Log In", fontWeight = FontWeight.Bold, fontSize = 40.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            dbHandler.addData(email = email.value, password = password.value)
        }) {
            Text("Sign Up")
        }
    }
}