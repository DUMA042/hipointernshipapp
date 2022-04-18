package com.example.hipointernapp.Uilayer.NavigationLayer

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import com.example.hipointernapp.Uilayer.NavigationLayer.UiUtility.Screen
import com.example.hipointernapp.Uilayer.UiScreens.CreateapplicationScreen
import com.example.hipointernapp.Uilayer.UiScreens.HomeScreen


@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route= Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(route = Screen.CreateScreen.route){
            CreateapplicationScreen()
        }
    }
}


@Composable
fun Bottombar(navController: NavController){
    val screens= listOf(Screen.HomeScreen,
        Screen.CreateScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentdestination=navBackStackEntry?.destination
    BottomNavigation{
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentdestination, navController =navController )
        }
    }

}
@Composable
fun RowScope.AddItem(screen: Screen, currentDestination: NavDestination?, navController: NavController){
    BottomNavigationItem(label={Text(text=screen.title)}, icon = {},selected = currentDestination?.hierarchy?.any{
        it.route==screen.route

    }==true, onClick = {
        navController.navigate(screen.route)
    })

}