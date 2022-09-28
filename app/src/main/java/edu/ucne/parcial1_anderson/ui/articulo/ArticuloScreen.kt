package edu.ucne.parcial1_anderson.ui.articulo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.Scaffold
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ArticuloScreen(
    onNavigateBack: () -> Unit,
    /*viewModel: RegistroViewModel = hiltViewModel()*/
) {
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(
                    context,
                    "El boton funciona",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Agregar un articulo")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

        }
    }
}