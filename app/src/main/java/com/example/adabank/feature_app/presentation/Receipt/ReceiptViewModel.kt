package com.example.adabank.feature_app.presentation.Receipt

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(ReceiptState())
    val state: State<ReceiptState> = _state
}