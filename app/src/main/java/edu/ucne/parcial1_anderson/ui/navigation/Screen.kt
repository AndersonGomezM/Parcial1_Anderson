package edu.ucne.parcial1_anderson.ui.navigation

sealed class Screen(val route: String){
    object HomeScreen: Screen("Home")
    object RegistroScreen: Screen("Registro")
    object RegistroListScreen: Screen("RegistroList")
}
