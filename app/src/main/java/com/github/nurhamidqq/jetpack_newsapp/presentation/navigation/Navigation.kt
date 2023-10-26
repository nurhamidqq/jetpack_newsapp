package com.github.nurhamidqq.jetpack_newsapp.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.github.nurhamidqq.jetpack_newsapp.presentation.onboarding.OnBoardingScreen
import com.github.nurhamidqq.jetpack_newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun Navigation(
    startDestination : String
) {
    val navController = rememberNavController()

    NavHost(navController=navController,startDestination = startDestination,){
        navigation(startDestination = Route.OnBoardingScreen.route,route = Route.AppStartNavigation.route){
            composable(route = Route.OnBoardingScreen.route){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(startDestination = Route.NewsNavigatorScreen.route,route = Route.NewsNavigation.route){
            composable(route = Route.NewsNavigatorScreen.route){
                Text(text = "Hello News App")
            }
        }
    }

}