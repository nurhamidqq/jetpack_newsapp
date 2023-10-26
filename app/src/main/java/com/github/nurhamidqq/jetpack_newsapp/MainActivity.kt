package com.github.nurhamidqq.jetpack_newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.github.nurhamidqq.jetpack_newsapp.domain.usecases.AppEntryUsecases
import com.github.nurhamidqq.jetpack_newsapp.presentation.onboarding.OnBoardingScreen
import com.github.nurhamidqq.jetpack_newsapp.presentation.onboarding.OnBoardingViewModel
import com.github.nurhamidqq.jetpack_newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUsecases: AppEntryUsecases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,true)
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUsecases.readAppEntry().collect{
                Log.d("Test",it.toString())
            }
        }
        setContent {
            NewsAppTheme(
                dynamicColor = false
            ) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    val viewModel:OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                    )
                }
            }
        }
    }
}