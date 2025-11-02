package com.example.residencehub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.residencehub.screens.LoginScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.LOGIN
    ) {
        composable(AppRoutes.LOGIN) {
            // State and Logic for the Login Screen are handled here

            //  use a ViewModel here to handle the actual login call
            // and observe the state (success/error/loading).





    }
}}

// NOTE: For the project to compile, you must also have a minimal DashboardScreen.kt file.
// I recommend adding a simple placeholder to com.example.residencehub.screens/DashboardScreen.kt.