package com.example.adabank.feature_app.presentation.Menu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(MenuState())
    val state: State<MenuState> = _state

    fun onEvent(event: MenuEvent){
        when (event){
            is MenuEvent.EnterSearchText -> {
                _state.value = state.value.copy(searchText = event.value)
            }
        }
    }
}