package com.example.cashew.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.cashew.components.TransactionRow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransactionsList() {
    LazyColumn {
        items(getTransactions().size) {
            val transaction = getTransactions()[it]

            TransactionRow(
                title = transaction.title,
                amount = transaction.amount.toString(),
                note = transaction.note,
                category = transaction.category,
            )
        }
    }
}

fun getTransactions(): MutableList<Transaction> {
    val transactions = mutableListOf<Transaction>()
    transactions.add(Transaction("taco bell", -100L, "lunch at Freddie's", "food"))
    transactions.add(Transaction("chapati", -20L, "lunch at Freddie's", "food"))
    transactions.add(Transaction("haircut", -200L, category = "grooming"))
    transactions.add(Transaction(amount = 44832L, category = "income"))
    transactions.add(Transaction("recharge", -899L, category = "Subscriptions"))
    return transactions
}