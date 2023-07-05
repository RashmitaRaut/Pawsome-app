package com.example.pawsome.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawsome.R
import com.example.pawsome.components.*

@Composable
fun LoginScreen(navController: NavController){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier = Modifier
            .fillMaxSize()) {

            NormalTextComponent(value = stringResource(id = R.string.loginScreen_greeting))

            HeadingTextComponent(value = stringResource(id = R.string.loginScreen_welcome))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(labelValue = stringResource(id = R.string.name1))

            Spacer(modifier = Modifier.height(10.dp))

            MyPasswordField(labelValue = "Password")

            Spacer(modifier = Modifier.height(10.dp))

            UnderLinedTextComponent(value = "Forgot Password?")

            Spacer(modifier = Modifier.height(20.dp))

            LoginComponent(navController = navController)
            
            Image(
                modifier = Modifier.fillMaxSize().rotate(12f).size(1000.dp),
                painter = painterResource(id = R.drawable.pet_family_removebg_preview),
                contentDescription = "loginscreen_img")
        }


    }
}