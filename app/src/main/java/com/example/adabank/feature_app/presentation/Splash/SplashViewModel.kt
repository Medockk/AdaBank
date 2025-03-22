package com.example.adabank.feature_app.presentation.Splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.usecase.Auth.IsUserRegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isUserRegistrationUseCase: IsUserRegistrationUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SplashState())
    val state: State<SplashState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val isUserRegistered = isUserRegistrationUseCase()
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        isUserRegistered = isUserRegistered
                    )
                }
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
        }
    }

    fun resetException(){
        _state.value = state.value.copy(exception = "")
    }
}