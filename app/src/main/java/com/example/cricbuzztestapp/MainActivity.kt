package com.example.cricbuzztestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.cricbuzztestapp.navigation.ScreenNavigation
import com.example.cricbuzztestapp.sneakerscreen.presentation.HomeScreen
import com.example.cricbuzztestapp.sneakerscreen.viewmodel.HomeViewmodel
import com.example.cricbuzztestapp.ui.theme.CricbuzzTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricbuzzTestAppTheme {
                val context = LocalContext.current
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                window.statusBarColor = MaterialTheme.colors.background.toArgb()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenNavigation(context = context.applicationContext, navController)
                }
            }
        }
    }
}

