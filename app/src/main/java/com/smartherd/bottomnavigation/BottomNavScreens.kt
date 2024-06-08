package com.smartherd.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route:String,
    val name:String,
    val icon: ImageVector

) {
    object HomeScreen:BottomNavScreens(
        route = "home",
        name = "Home",
        icon = Icons.Default.Home
    )
    object ProfileScreen:BottomNavScreens(
        route = "profile",
        name = "Profile",
        icon = Icons.Default.Person
    )
    object SettingScreen:BottomNavScreens(
        route = "settings",
        name = "Settings",
        icon = Icons.Default.Settings
    )


}