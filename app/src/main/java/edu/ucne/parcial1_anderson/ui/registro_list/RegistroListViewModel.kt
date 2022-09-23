package edu.ucne.parcial1_anderson.ui.registro_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_anderson.data.RegistroDb
import edu.ucne.parcial1_anderson.data.entity.RegistroEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegistroListUiState(
    val registros: List<RegistroEntity> = emptyList(),
    val text: String = "Meeting"
)

@HiltViewModel
class RegistroListViewModel @Inject constructor(
    /*val repository: Registrorepository*/
): ViewModel() {
    private val _uiState = MutableStateFlow(RegistroListUiState())
    val uiState: StateFlow<RegistroListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            /*repository.getList().collect {
                _uiState.update {
                    it.copy( registros = list )
                }
            }*/
        }
    }
}