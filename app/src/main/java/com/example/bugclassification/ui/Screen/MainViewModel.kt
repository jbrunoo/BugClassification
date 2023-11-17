package com.example.bugclassification.ui.Screen

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState(bitmap = null))
    val uiState: StateFlow<MainUiState> get() = _uiState

    fun setBitmap(bitmap: Bitmap?) {
        viewModelScope.launch {
            _uiState.emit(_uiState.value.copy(bitmap = bitmap))
        }
    }

}