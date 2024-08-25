package com.example.menoo.navigation

import java.lang.IllegalArgumentException

enum class MenooScreens {
    SplashScreen ,
    HomeScreen ,
    DetailsScreen ,
    SearchScreen ,
    ProfileScreen ,
    UpdateMenuScreen ,
    UpdatePricingScreen ;

    companion object{
        fun fromRoute(route:String?): MenooScreens = when(route?.substringBefore("/")){
                SplashScreen.name -> SplashScreen
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                SearchScreen.name -> SearchScreen
                ProfileScreen.name -> ProfileScreen
                UpdateMenuScreen.name -> UpdateMenuScreen
                UpdatePricingScreen.name -> UpdatePricingScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("route $route not found")
            }

        }
}