package com.example.realm_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.Home.name ) {
        homeRoute()
    }
}