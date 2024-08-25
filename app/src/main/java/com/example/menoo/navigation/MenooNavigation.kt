package com.example.menoo.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.menoo.screens.DetailsScreen
import com.example.menoo.screens.HomeScreen
import com.example.menoo.screens.ProfileScreen
import com.example.menoo.screens.SearchScreen
import com.example.menoo.screens.SplashScreen
import com.example.menoo.screens.UpdateMenuScreen
import com.example.menoo.screens.UpdatePricingScreen

@Composable
fun MenooNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MenooScreens.SearchScreen.name) {
        composable(MenooScreens.SplashScreen.name){
            SplashScreen()
        }
        composable(MenooScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(MenooScreens.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
        composable(MenooScreens.ProfileScreen.name){
            ProfileScreen(navController = navController)
        }
        composable(MenooScreens.UpdateMenuScreen.name){
            UpdateMenuScreen(navController = navController)
        }
        composable(MenooScreens.UpdatePricingScreen.name){
            UpdatePricingScreen(navController = navController)
        }
        composable(MenooScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
    }
}