package edu.ucne.parcial1_anderson.ui.navigation

sealed class Screen(val route: String){
    object HomeScreen: Screen("Home")
    object ArticuloScreen: Screen("Articulo")
    object ArticuloListScreen: Screen("ArticuloList")
}
