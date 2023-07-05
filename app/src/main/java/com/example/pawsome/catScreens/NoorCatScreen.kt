package com.example.pawsome.catScreens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsome.R
import com.example.pawsome.components.BottomNavigationBarComponent

@Composable
fun NoorCatInfo(navController: NavController) {
    BottomNavigationBarComponent(navController = navController)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Card(
            modifier = Modifier
                .size(350.dp, 650.dp), elevation = 8.dp
        ) {

            Column(verticalArrangement = Arrangement.Top) {
                Image(
                    painter = painterResource(id = R.drawable.noorcat),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .size(300.dp),
                    Alignment.TopCenter,
                )

                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Noor",
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp, modifier = Modifier.padding(start = 25.dp, end = 20.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                    )

                    var isClicked by remember { mutableStateOf(false) }
                    val iconColor by animateColorAsState(if (isClicked) Color.Red else Color.Gray)
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Fav icon",
                        tint = iconColor,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable { isClicked = !isClicked }
                    )
                }


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Pune (2.5 Km)",
                        fontSize = 14.sp,
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val options = listOf("Female", "3 Kgs", "Tabby cat")
                    val selectedOptions = remember { mutableStateListOf<String>() }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        options.forEach { option ->
                            Button(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(15.dp))
                                    .padding(2.dp)
                                    .shadow(5.dp),
                                onClick = {
                                    if (selectedOptions.contains(option)) {
                                        selectedOptions.remove(option)
                                    } else {
                                        selectedOptions.add(option)
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.orchid_pink)
                                )
                            ) {
                                Text(text = option)
                            }
                        }
                    }
                }
                
                Text(text = stringResource(id = R.string.Noor_adoption_message),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.orchid_pink)
                    ),
                    modifier = Modifier.padding(start = 65.dp)
                ) {
                    Text(text = "Chat with the owner",
                    modifier = Modifier.padding(4.dp)
                    )
                }

            }
        




            }
                }}









