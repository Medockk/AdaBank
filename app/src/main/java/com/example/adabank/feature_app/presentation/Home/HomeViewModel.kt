package com.example.adabank.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.model.TransactionHistory
import com.example.adabank.feature_app.domain.usecase.CardOperation.GetSendAgainDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.GetTransactionHistoryDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.UpsertSendAgainDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.UpsertTransactionDataUseCase
import com.example.adabank.feature_app.domain.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.abs
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val upsertSendAgainDataUseCase: UpsertSendAgainDataUseCase,
    private val getSendAgainDataUseCase: GetSendAgainDataUseCase,
    private val upsertTransactionDataUseCase: UpsertTransactionDataUseCase,
    private val getTransactionHistoryDataUseCase: GetTransactionHistoryDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getSendAgainData()
                getTransactionHistory()
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    exception = e.message.toString()
                )
            }
        }
    }

    private suspend fun getTransactionHistory() {
        (1..5).forEach {
            upsertTransactionDataUseCase(
                TransactionHistory(
                    it,
                    it.toString(),
                    image = "https://uftclonibwagnofwkbtp.supabase.co/storage/v1/object/public/avatars//default_users_icon.png",
                    "title$it",
                    it.toString(),
                    abs(Random.nextInt()).toString(),
                    sendTo = "user with id: $it"
                )
            )
        }

        (1..5).forEach { id ->
            getTransactionHistoryDataUseCase(id.toString()).collect{
                when (it){
                    is NetworkResult.Error<*> -> {
                        _state.value = state.value.copy(
                            showIndicator = false,
                            exception = it.message ?: "unknown error"
                        )
                    }
                    is NetworkResult.Loading<*> -> {
                        _state.value = state.value.copy(
                            showIndicator = true
                        )
                    }
                    is NetworkResult.Success<*> -> {
                        withContext(Dispatchers.Main){
                            _state.value = state.value.copy(
                                transactionList = _state.value.transactionList + (it.data ?: emptyList())
                            )
                        }
                    }
                }
            }
        }
    }

    private suspend fun getSendAgainData() {
        (1..5).forEach {
            upsertSendAgainDataUseCase(
                SendAgain(
                    it,
                    it.toString(),
                    "https://uftclonibwagnofwkbtp.supabase.co/storage/v1/object/public/avatars//default_users_icon.png",
                    "name$it",
                    abs(Random.nextInt()).toString()
                )
            )
        }

        (1..5).forEach { id ->
            getSendAgainDataUseCase(id.toString()).collect{
                when (it){
                    is NetworkResult.Error<*> -> {
                        _state.value = state.value.copy(
                            exception = it.message ?: "unknown error",
                            showIndicator = false
                        )
                    }
                    is NetworkResult.Loading<*> -> {
                        _state.value = state.value.copy(
                            showIndicator = true
                        )
                    }
                    is NetworkResult.Success<*> -> {
                        withContext(Dispatchers.Main){
                            _state.value = state.value.copy(
                                sendAgainList = _state.value.sendAgainList + (it.data ?: emptyList())
                            )
                        }
                    }
                }
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}