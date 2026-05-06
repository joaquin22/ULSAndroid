package com.uls.practica_6.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uls.practica_6.ui.screens.FormScreen
import com.uls.practica_6.ui.screens.ListUsersScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list_users"
    ) {

        composable("list_users") {
            ListUsersScreen(navController = navController)
        }

        composable("add_user") {
            FormScreen(navController = navController)
        }
    }
}