package com.example.pawsome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pawsome.catScreens.MaltipooDogInfo
import com.example.pawsome.catScreens.NoorCatInfo
import com.example.pawsome.screens.*
import com.example.pawsome.ui.theme.PawsomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawsomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PawsomeApp()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen")
    {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        //First Screen
        composable("first_screen") {
            EnterScreen(navController = navController)
        }

        //Sign up Screen
        composable("signup_screen"){
            SignupScreen(navController = navController)
        }

        //Login Screen
        composable("login_screen") {
            LoginScreen(navController = navController)
        }

        //Main screen
        composable("main_screen") {
            MainScreen(navController = navController)
        }

        composable("NoorCatScreen") {
            NoorCatInfo(navController = navController)
        }

        composable("MaltipooDogScreen") {
            MaltipooDogInfo(navController = navController)
        }



    }
}

@Composable
fun PawsomeApp(){
    Navigation()
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PawsomeTheme {
        PawsomeApp()
    }
}