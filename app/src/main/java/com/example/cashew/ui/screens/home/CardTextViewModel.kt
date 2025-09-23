package com.example.cashew.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CardTextViewModel : ViewModel() {
    var cardText by mutableStateOf("")
}