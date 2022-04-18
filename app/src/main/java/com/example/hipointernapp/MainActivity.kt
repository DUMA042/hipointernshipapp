package com.example.hipointernapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.hipointernapp.Uilayer.NavigationLayer.Bottombar
import com.example.hipointernapp.Uilayer.NavigationLayer.NavigationGraph
import com.example.hipointernapp.ui.theme.HipoInternAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HipoInternAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { Bottombar(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HipoInternAppTheme {
        Main()
    }
}