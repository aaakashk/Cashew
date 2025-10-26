package com.example.cashew.domain.model

data class Account(
    val id: Int,
    val name: String,
    val balance: Long,
    val transactionsCount: Int,
    val isPrimary: Boolean,
    val decimalPlaces: Int = 2,
    val currency: String = "INR",
)
