package edu.ucne.parcial1_anderson.ui.articulo

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ArticuloScreen(
    onNavigateBack: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    fun validacion() {
        if (viewModel.descripcion.isBlank() || viewModel.marca.isBlank() || viewModel.existencia.isBlank()){
                Toast.makeText(
                    context,
                    "Debe rellenar la casilla vacia",
                    Toast.LENGTH_SHORT
                ).show()
        }else{
            if(ValidarNumero(viewModel.existencia)) {
                viewModel.save()
                onNavigateBack()
            }
            else{
                Toast.makeText(
                    context,
                    "Rellene bien la casilla de existencia",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                validacion()
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "Registro de Articulos",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripción") },
                value = viewModel.descripcion,
                onValueChange = { viewModel.descripcion = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Marca") },
                value = viewModel.marca,
                onValueChange = { viewModel.marca = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Existencia") },
                value = viewModel.existencia,
                onValueChange = { viewModel.existencia = it },
                keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Number)
            )
        }
    }
}

fun ValidarNumero(textoValidar: String) : Boolean{
    try {
        textoValidar.toDouble()
        return true
    }catch (e: Exception){
        return false
    }
}