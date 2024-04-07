package com.example.realm_demo.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.realm_demo.screen.home.HomeScreen
import com.example.realm_demo.screen.home.HomeViewModel

fun NavGraphBuilder.homeRoute() {
    composable(Routes.Home.name) {
        val homeViewModel: HomeViewModel = hiltViewModel()
        val courses by homeViewModel.courses.collectAsState()

        HomeScreen(courses = courses,
            selectedCourse = homeViewModel.selectedCourse,
            onClickCourse = {course ->
            homeViewModel.selectCourse(course)
        }, onClearCourse = homeViewModel::clearSelectedCourse, onDeleteCourse = {course ->
                homeViewModel.deleteCourse(course)
            })
    }
}