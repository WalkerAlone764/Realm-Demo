package com.example.realm_demo.navigation

sealed class Routes(val name: String) {
    data object Home: Routes("Home")
}