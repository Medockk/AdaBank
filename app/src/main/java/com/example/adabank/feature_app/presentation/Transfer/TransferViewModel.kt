package com.example.adabank.feature_app.presentation.Transfer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.model.Contact
import com.example.adabank.feature_app.domain.usecase.Contact.ClearContactDataUseCase
import com.example.adabank.feature_app.domain.usecase.Contact.GetContactDataUseCase
import com.example.adabank.feature_app.domain.usecase.Contact.UpsertContactDataUseCase
import com.example.adabank.feature_app.domain.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.abs
import kotlin.random.Random

@HiltViewModel
class TransferViewModel @Inject constructor(
    private val upsertContactDataUseCase: UpsertContactDataUseCase,
    private val getContactDataUseCase: GetContactDataUseCase,
    private val clearContactDataUseCase: ClearContactDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TransferState())
    val state: State<TransferState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            (1..5).forEach {
                upsertContactDataUseCase(
                    Contact(
                        it,
                        it.toString(),
                        "https://uftclonibwagnofwkbtp.supabase.co/storage/v1/object/public/avatars//default_users_icon.png",
                        "name $it",
                        abs(Random.nextInt()).toString()
                    ).toContactDto()
                )
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            (1..5).forEach {
                getContactDataUseCase(it.toString()).collect {
                    when (it) {
                        is NetworkResult.Error<*> -> {
                            _state.value = state.value.copy(exception = it.message ?: "xz")
                        }

                        is NetworkResult.Loading<*> -> {}
                        is NetworkResult.Success<*> -> {
                            withContext(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    contactList = _state.value.contactList + (it.data
                                        ?: emptyList())
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun onEvent(event: TransferEvent) {
        when (event) {
            TransferEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            is TransferEvent.GetContact -> {

            }

            is TransferEvent.EnterSearchText -> {
                _state.value = state.value.copy(searchText = event.value)
            }

            is TransferEvent.ChangeSelectedContactNumber -> {
                _state.value = state.value.copy(selectedContactNumber = event.value)
            }
        }
    }
}