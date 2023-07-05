package com.example.pawsome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawsome.R
import com.example.pawsome.components.*

@Composable
fun SignupScreen(navController: NavController){

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier = Modifier
            .fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.signinScreen_greeting))
            
            HeadingTextComponent(value = stringResource(id = R.string.siginScreen_question))
            
            Spacer(modifier = Modifier.height(20.dp))
            
            MyTextField(labelValue = stringResource(id = R.string.name1))
            
            MyTextField(labelValue = stringResource(id = R.string.name2))
            
            MyEmailField(labelValue = stringResource(id = R.string.name3))
            
            MyPasswordField(labelValue = "Password")
            
            CheckboxComponents(value = stringResource(id = R.string.policy))
            
            Spacer(modifier = Modifier.height(20.dp))
            
            RegisterComponent(navController = navController) //BUTTONS
            
            Spacer(modifier = Modifier.height(10.dp))
            
            DividerTextComposable()
            
            Spacer(modifier = Modifier.height(5.dp))
            
            AlreadyAnAccountComponent(navController = navController) //BUTTONS

        }


    }

}


