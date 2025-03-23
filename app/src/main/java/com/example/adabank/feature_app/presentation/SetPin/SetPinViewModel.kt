package com.example.adabank.feature_app.presentation.SetPin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.usecase.Auth.SetPinCodeUseCase
import com.example.adabank.feature_app.domain.usecase.Auth.UseFingerprintUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetPinViewModel @Inject constructor(
    private val setPinCodeUseCase: SetPinCodeUseCase,
    private val useFingerprintUseCase: UseFingerprintUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SetPinState())
    val state: State<SetPinState> = _state

    fun onEvent(event: SetPinEvent) {
        when (event) {
            SetPinEvent.NextClick -> {
                if (_state.value.pin.length == 4) {
                    viewModelScope.launch(Dispatchers.IO) {
                        if(
                            !useFingerprintUseCase().isNullOrBlank() &&
                            useFingerprintUseCase() == _state.value.pin
                        ){
                            _state.value = state.value.copy(
                                isAuthenticated = true
                            )
                        }else{
                            setPinCodeUseCase(_state.value.pin)
                            _state.value = state.value.copy(isComplete = true)
                        }
                    }
                }
            }

            SetPinEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            is SetPinEvent.SetPin -> {
                if (_state.value.pin.length < 4) {
                    _state.value = state.value.copy(pin = event.value)
                }
            }

            SetPinEvent.DeletePinCharacter -> {
                _state.value = state.value.copy(
                    pin = _state.value.pin.dropLast(1)
                )
            }
        }
    }
}