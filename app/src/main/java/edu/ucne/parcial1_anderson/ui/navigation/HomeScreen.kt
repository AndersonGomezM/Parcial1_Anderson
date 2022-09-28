package edu.ucne.parcial1_anderson.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onClickArticulo: () -> Unit
) {
    Inicio(onClickArticulo)
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Inicio(onClickArticulo: () -> Unit) {
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
    ){
        Button(onClick = onClickArticulo) {
            Text(text = "Boton para los registros")
        }
    }
}