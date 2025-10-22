package com.example.cashew.ui.screens.home

import androidx.lifecycle.ViewModel

data class Transaction(
    val title: String? = null,
    val amount: Long,
    val note: String? = null,
    val category: String,
) : ViewModel()