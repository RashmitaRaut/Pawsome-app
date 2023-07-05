package com.example.pawsome.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsome.R

@Composable
fun EnterScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(painter = painterResource(id = R.drawable.pawsome_cover),
                contentDescription = "logo")

            Text(
                text = stringResource(id = R.string.app_slogan),
                fontSize = 35.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top=350.dp, start = 56.dp)
            )
        }

        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "Find your new friends",
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )

        Spacer(modifier = Modifier.height(5.dp))


        val buttonColor = colorResource(R.color.brown)
        Button(onClick = { navController.navigate("signup_screen") },
            modifier = Modifier
                .width(200.dp) // Set the desired width
                .height(60.dp) // Set the desired height
                .padding(8.dp), // Optional padding for the button
            colors = ButtonDefaults.buttonColors(
                backgroundColor = buttonColor,
                contentColor = Color.White
            )
        ) {
            Text(text = "Get started")
            
        }
    }
    }








     




