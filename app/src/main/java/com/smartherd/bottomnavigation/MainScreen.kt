package com.smartherd.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        BottomNavGraph(navController = navController)
    }

}

@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomNavScreens.HomeScreen,
        BottomNavScreens.SettingScreen,
        BottomNavScreens.ProfileScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(label = { Text(text = screen.name) }, icon = {
        Icon(
            imageVector = screen.icon,
            contentDescription = "Navigation Icon"
        )
    }, selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true, unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )

}





