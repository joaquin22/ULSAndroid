package com.uls.practica_6.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.uls.practica_6.model.User
import com.uls.practica_6.ui.content.ListContent

@Composable
fun ListUsersScreen(
    navController: NavController
) {

    var users by remember {
        mutableStateOf(listOf(
            User("Maria", 21, true),
            User("Juan", 24),
            User("Pedro", 22)
        ))
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick={navController.navigate("add_user")}
            ){
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    ){
            padding ->

        ListContent(
            users,
            padding,
            onDelete = { user ->
                users = users.filter { it != user }
            },
            onFavorite = { user ->
                users = users.map {
                    if (it == user) it.copy(isFavorite = !it.isFavorite)
                    else it
                }
            }
        )

    }

}