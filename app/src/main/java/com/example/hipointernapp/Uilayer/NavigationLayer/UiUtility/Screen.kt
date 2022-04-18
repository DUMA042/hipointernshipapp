package com.example.hipointernapp.Uilayer.NavigationLayer.UiUtility

sealed class Screen(val route:String,val title:String="No Title"){
    object HomeScreen :Screen("main_screen","HOME")
    object CreateScreen : Screen("detail_screen","CREATE")

}
