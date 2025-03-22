package com.example.adabank.feature_app.presentation.Notification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(NotificationState())
    val state: State<NotificationState> = _state

    init {

    }

    fun onEvent(event: NotificationEvent){
        when (event){
            NotificationEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}