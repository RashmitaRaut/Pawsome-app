package com.example.pawsome.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsome.R


@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 23.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String){
    val textValue = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200),
            backgroundColor = colorResource(id = R.color.platinum)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = "")

        }
    )
}

@Composable
fun MyEmailField(labelValue: String){
    val textValue = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200),
            backgroundColor = colorResource(id = R.color.platinum)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = "")

        }
    )
}

@Composable
fun MyPasswordField(labelValue: String){
    val password = remember {
        mutableStateOf("")
    }

    remember {
        mutableStateOf(false)
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200),
            backgroundColor = colorResource(id = R.color.platinum)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "")
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    password.value = ""
                }
            ) {
                Icon(Icons.Default.Clear, contentDescription = "Clear password")
            }
        }
    )
}

@Composable
fun CheckboxComponents(value: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value,
            onCheckedChange ={
                checkedState.value = it
            },
        )

        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = value,
            fontSize = 12.sp
        )
    }
}

@Composable
fun RegisterComponent(navController: NavController) {

    Box(
        modifier = Modifier.padding(start = 65.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                try {
                    navController.navigate("main_screen")
                } catch (e: Exception){
                    Log.e("Exception", "Error navigating to MainScreen", e)
                }
             },
            modifier = Modifier
                .width(200.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.brown),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp),


        ) {
            Text(text = "Sign-in", fontSize = 16.sp)
        }
    }
}

@Composable
fun DividerTextComposable(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), thickness = 1.dp)



        Text(text = "or", fontSize = 12.sp, modifier = Modifier.padding(10.dp))



        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), thickness = 1.dp)
    }
}

@Composable
fun AlreadyAnAccountComponent(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Already have an account? Login",
            modifier = Modifier.padding(start = 45.dp),
            fontSize = 13.sp,
        )

        Spacer(modifier = Modifier.height(25.dp))
        Box(
            modifier = Modifier.padding(start = 65.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    try {
                        navController.navigate("login_screen")
                    } catch (e: Exception){
                        e.printStackTrace()
                    }
                     },
                modifier = Modifier
                    .width(200.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.brown),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50.dp),


                ) {
                Text(text = "Login", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun UnderLinedTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun LoginComponent(navController: NavController) {
    Box(
        modifier = Modifier.padding(start = 65.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate("main_screen") },
            modifier = Modifier
                .width(200.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.brown),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp),


            ) {
            Text(text = "Login", fontSize = 16.sp)
        }
    }
}



