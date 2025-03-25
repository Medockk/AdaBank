package com.example.adabank.feature_app.presentation.TransferDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.adabank.feature_app.presentation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransferDetailViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(TransferDetailState())
    val state: State<TransferDetailState> = _state

    fun onEvent(event: TransferDetailEvent){
        when (event){
            is TransferDetailEvent.EnterAmount -> {
                _state.value = state.value.copy(amount = event.value)
                Route.TransferDetailScreen.amount = event.value
            }
            TransferDetailEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            TransferDetailEvent.DeleteLastCharacter -> {
                _state.value = state.value.copy(amount = _state.value.amount.dropLast(1))
            }

            is TransferDetailEvent.ChangeShowIndicatorState -> {
                _state.value = state.value.copy(showIndicator = event.value)
            }
        }
    }
}