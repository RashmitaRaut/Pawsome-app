package com.example.pawsome.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsome.R
import com.example.pawsome.components.BottomNavigationBarComponent
import com.example.pawsome.components.cardItems
import com.example.pawsome.components.dogCardItems


@Composable                                                                 // MainScreen.kt
fun MainScreen(navController: NavController) {
    val textValue = remember {
        mutableStateOf("")
    }
    BottomNavigationBarComponent(navController = navController)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(55.dp))

/***************************Thought of the day***************************************************/
        Image(
            painter = painterResource(id = R.drawable.mainscreen_image),
            contentDescription = "quote on pet adoption",
            Modifier
                .padding(20.dp)
                .shadow(12.dp)
                .clip(RoundedCornerShape(12.dp)),
        )

 /***************************Search Button***************************************************/

        TextField(
            modifier = Modifier
                .width(315.dp)
                .height(56.dp)                 //Search Box
                .background(
                    color = colorResource(id = R.color.Fawn),
                    shape = RoundedCornerShape(2.dp)
                ),
            label = { Text(text = "Search", color = Color.Black) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            value = textValue.value,
            onValueChange = {
                textValue.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

/***************************Pet Categories***************************************************/

        Text(
            text = "Pet Categories",
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(end = 215.dp)

        )

/***************************Pet category button***************************************************/

        val options = listOf("Cat", "Dog", "Turtle", "Hams")
        val selectedOptions = remember { mutableStateListOf<String>() }
        Column(modifier = Modifier.padding(start = 12.dp) ) {
            LazyRow(
                modifier = Modifier.widthIn(max = 6000.dp)
            ) {
                items(options) { option ->
                    Button(
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .padding(8.dp)
                            .shadow(5.dp),
                        onClick = {
                            if (selectedOptions.contains(option)) {
                                selectedOptions.remove(option)
                            } else {
                                selectedOptions.add(option)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (selectedOptions.contains(option)) {
                                colorResource(id = R.color.rosy_brown)
                            } else {
                                Color.White
                            }
                        )
                    ){
                        Text(text = option)
                    }
                    }
            }
            
            Spacer(modifier = Modifier.height(10.dp))

/***************************Adopt a pet button***************************************************/

            Text(text = "Adopt a pet",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

/***************************Cats Scrollable List***************************************************/

            when {
                selectedOptions.contains("Cat") -> {
                    CatsScrollableList(navController = navController)
                }
                selectedOptions.contains("Dog") -> {
                    DogsScrollableList(navController = navController)
                }
                // Add more conditions for other categories
            }
        }
    }
}


@Composable
fun CatsScrollableList(navController: NavController){
    var selectedTabIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 16.dp,
        backgroundColor = Color.White,
        indicator = {}
    ){
        cardItems.forEachIndexed{ index, catsData ->  
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                    try {
                        selectedTabIndex = index
                        navController.navigate(catsData.destinationRoute)
                    }catch (e: Exception){
                        Log.e("Exception", "Error navigating to NoorCatInfo screen", e)
                    }

                               },
                elevation = if (selectedTabIndex == index) 8.dp else 6.dp
            ) {
                Column(modifier = Modifier.padding(15.dp)) {
                    Image(
                        painter = painterResource(catsData.imageResId),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .size(175.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = catsData.text,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,

                    )
                }
            }
        }
    }
}

/***************************Dogs Scrollable List***************************************************/
@Composable
fun DogsScrollableList(navController: NavController){
    var selectedTabIndex by remember { mutableStateOf(0) }

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 16.dp,
        backgroundColor = Color.White,
        indicator = {}
    ){
        dogCardItems.forEachIndexed{ index, dogsData ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable { try {
                        selectedTabIndex = index
                        navController.navigate(dogsData.destinationRoute)
                    }catch (e: Exception){
                        Log.e("Exception", "Error navigating to NoorCatInfo screen", e)
                    } },
                elevation = if (selectedTabIndex == index) 8.dp else 6.dp
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Image(
                        painter = painterResource(dogsData.imageResId),
                        contentDescription = "Dogs Image",
                        modifier = Modifier
                            .size(175.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = dogsData.text,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif,

                        )
                }
            }
        }
    }
}

/***************************Turtle Scrollable List***************************************************/
/***************************Hamster Scrollable List***************************************************/








