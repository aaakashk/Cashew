package com.example.cashew.home

data class Account<T : Number>(
    val name: String,
    val balance: T,
    val transactionsCount: Int,
    val decimalPlaces: Int,
    val currency: String,
    val isPrimary: Boolean = false,
)