package com.smartherd.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BottomNavScreens.HomeScreen.route) {

        composable(
            BottomNavScreens.HomeScreen.route
        ){
            HomeScreen()
        }
        composable(
            BottomNavScreens.ProfileScreen.route
        ){
            ProfileScreen()
        }
        composable(
            BottomNavScreens.SettingScreen.route
        ){
            SettingScreen()
        }
    }


}