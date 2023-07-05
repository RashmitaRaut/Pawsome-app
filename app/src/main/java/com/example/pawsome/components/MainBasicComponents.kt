package com.example.pawsome.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pawsome.R


@Composable
fun TopAppBarComponent() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Pawsome",
                    maxLines = 1,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action click */ }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            }
        },
        backgroundColor = Color.Transparent,
    )
}

@Composable  //Home = main_screen, Fav = "Fav_screen, Chat= chat_screen, Profile="myProfile_screen
fun BottomNavigationBarComponent(navController: NavController) {
    val currentRoute = currentRoute(navController)

    Scaffold(
        topBar = { TopAppBarComponent() },
        bottomBar = {
            BottomNavigation(backgroundColor = Color.Transparent, elevation = 1.dp){
                BottomNavigationItem(
                    selected = currentRoute == MainDestinations.HOME_ROUTE,
                    onClick = {
                        navController.navigate(MainDestinations.HOME_ROUTE) {
                            popUpTo(MainDestinations.HOME_ROUTE) { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home", fontSize = 10.sp) }
                )

                BottomNavigationItem(
                    selected = currentRoute == MainDestinations.CHAT_ROUTE,
                    onClick = {
                        navController.navigate(MainDestinations.CHAT_ROUTE) {
                            popUpTo(MainDestinations.CHAT_ROUTE) { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Filled.Send, contentDescription = "Chat") },
                    label = { Text("Chat", fontSize = 10.sp) }
                )

                BottomNavigationItem(
                    selected = currentRoute == MainDestinations.FAV_ROUTE,
                    onClick = {
                        navController.navigate(MainDestinations.FAV_ROUTE) {
                            popUpTo(MainDestinations.FAV_ROUTE) { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Outlined.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites", fontSize = 10.sp) }
                )

                BottomNavigationItem(
                    selected = currentRoute == MainDestinations.PROFILE_ROUTE,
                    onClick = {
                        navController.navigate(MainDestinations.PROFILE_ROUTE) {
                            popUpTo(MainDestinations.PROFILE_ROUTE) { inclusive = true }
                        }
                    },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile", fontSize = 10.sp) }
                )
            }
        }
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            // Content of the screen goes here
        }
    }
}


@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val CHAT_ROUTE = "chat"
    const val FAV_ROUTE = "favorites"
    const val PROFILE_ROUTE = "profile"
}

@Composable
fun SearchBarComponent(labelValue: String){
    val textValue = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .clip(RoundedCornerShape(18.dp)).padding(top = 75.dp, start = 52.dp),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200),
            backgroundColor = colorResource(id = R.color.platinum)
        ),
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
}






