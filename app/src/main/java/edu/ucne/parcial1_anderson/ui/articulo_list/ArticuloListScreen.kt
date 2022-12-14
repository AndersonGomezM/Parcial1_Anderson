package edu.ucne.parcial1_anderson.ui.articulo_list

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.Card
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity

@Composable
fun ArticuloListScreen (
    onClick: () -> Unit,
    viewModel: ArticuloListViewModel = hiltViewModel()
) {
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Inserta un articulo")
            }
        }
    ){
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "Lista de Articulos",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            ArticuloList(
                articulos = uiState.articulos,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun ArticuloList(
    articulos: List<ArticuloEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(articulos) { articulo ->
            ArticuloRow(articulo)
        }
    }
}

@Composable
fun ArticuloRow(articulo: ArticuloEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
        elevation = 16.dp,
        backgroundColor = Color(0x8574C8E9)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row() {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = articulo.descripcion,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Marca: ${articulo.marca}"
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Existencia: ${articulo.existencia}"
                )

            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview() {
    val lista = listOf(

        ArticuloEntity(
            descripcion = "Prueba1",
            marca = "funciona",
            existencia = 10.00
        ),
        ArticuloEntity(
            descripcion = "Prueba2",
            marca = "sigue funcionando",
            existencia = 20.00
        )
    )

    ArticuloList(articulos = lista)
}