package com.example.cashew.domain.model

data class Transaction(
    val id: Int,
    val title: String?,
    val amount: Long,
    val note: String?,
    val type: TransactionType,
    val accountId: Int,
    val categoryId: Int?,
)
