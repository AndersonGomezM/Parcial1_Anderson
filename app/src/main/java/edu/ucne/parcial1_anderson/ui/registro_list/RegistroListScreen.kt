package edu.ucne.parcial1_anderson.ui.registro_list

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
import edu.ucne.parcial1_anderson.data.entity.RegistroEntity

@Composable
fun RegistroListScreen (
    onClick: () -> Unit,
    viewModel: RegistroListViewModel = hiltViewModel()
) {
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Inserta un registro")
            }
        }
    ){
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            RegistroList(
                registros = uiState.registros,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun RegistroList(
    registros: List<RegistroEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(registros) { registro ->
            RegistroRow(registro)
        }
    }
}

@Composable
fun RegistroRow(registro: RegistroEntity) {
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
                    text = registro.variable1,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Numeritos: ${registro.num}"
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

        RegistroEntity(
            variable1 = "Prueba1",
            variable2 = "funciona",
            num = 10.00
        ),
        RegistroEntity(
            variable1 = "Prueba2",
            variable2 = "sigue funcionando",
            num = 20.00
        )
    )

    RegistroList(registros = lista)
}