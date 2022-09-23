package edu.ucne.parcial1_anderson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_anderson.ui.navigation.Screen
import edu.ucne.parcial1_anderson.ui.navigation.HomeScreen
import edu.ucne.parcial1_anderson.ui.registro.RegistroScreen
import edu.ucne.parcial1_anderson.ui.registro_list.RegistroListScreen
import edu.ucne.parcial1_anderson.ui.theme.Parcial1_AndersonTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_AndersonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Inicio()
                }
            }
        }
    }
}

@Composable
fun Inicio() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route){
            HomeScreen(
                onClickRegistro = { navController.navigate(Screen.RegistroListScreen.route) }
            )
        }

        composable(Screen.RegistroListScreen.route){
            RegistroListScreen(
                onClick = { navController.navigate(Screen.RegistroScreen.route) }
            )
        }

        composable(Screen.RegistroScreen.route){
            RegistroScreen({ navController.navigateUp() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial1_AndersonTheme {
        Inicio()
    }
}