package edu.ucne.parcial1_anderson.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    onClickRegistro: () -> Unit
) {
    Inicio(onClickRegistro)
}

@Composable
fun Inicio(onClickRegistro: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = { Text(text = "Aplicación de registros") },
        navigationIcon = {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription = null )
        }
    )
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colors.background
    ) {
        Button(onClick = onClickRegistro) {
            Text(text = "Boton para los registros")
        }
    }
}