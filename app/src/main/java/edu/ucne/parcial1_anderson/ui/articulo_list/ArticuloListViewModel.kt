package edu.ucne.parcial1_anderson.ui.articulo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity
import edu.ucne.parcial1_anderson.repository.ArticuloRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticuloListUiState(
    val articulos: List<ArticuloEntity> = emptyList(),
    val text: String = "Meeting"
)

@HiltViewModel
class ArticuloListViewModel @Inject constructor(
    val repository: ArticuloRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ArticuloListUiState())
    val uiState: StateFlow<ArticuloListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getList().collect { list ->
                _uiState.update {
                    it.copy( articulos = list )
                }
            }
        }
    }
}