package edu.ucne.parcial1_anderson.ui.articulo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity
import edu.ucne.parcial1_anderson.repository.ArticuloRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    val repository: ArticuloRepository
) : ViewModel() {

    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var existencia by mutableStateOf("")

    fun save(){
        viewModelScope.launch {
            repository.insertarArticulo(
                ArticuloEntity(
                    descripcion = descripcion,
                    marca = marca,
                    existencia = existencia.toDouble()
                )
            )
        }
    }
}