package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cashew.components.Tile

@Composable
fun AccountsRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(getAccounts()) { account ->
                Account(account = account)
            }
        }
    )
}

@Composable
fun Account(account: Account<Number>) {
    Tile(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = account.name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            text = "${formatBalance(account)} ${account.currency}",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = "${account.transactionsCount} transactions",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

fun getAccounts(): MutableList<Account<Number>> {
    val accounts = mutableListOf<Account<Number>>()
    accounts.add(
        Account(
            name = "SBI",
            balance = 1234.45,
            transactionsCount = 411,
            decimalPlaces = 2,
            currency = "INR",
            isPrimary = true,
        )
    )
    accounts.add(
        Account(
            name = "HDFC",
            balance = 999.45,
            transactionsCount = 21,
            decimalPlaces = 2,
            currency = "INR"
        )
    )
    accounts.add(
        Account(
            name = "Cash",
            balance = 1234,
            transactionsCount = 50,
            decimalPlaces = 1,
            currency = "INR",
        )
    )
    accounts.add(
        Account(
            name = "Cash",
            balance = 1234,
            transactionsCount = 50,
            decimalPlaces = 1,
            currency = "INR"
        )
    )
    accounts.add(
        Account(
            name = "Cash",
            balance = 1234,
            transactionsCount = 50,
            decimalPlaces = 1,
            currency = "INR"
        )
    )
    accounts.add(
        Account(
            name = "Cash",
            balance = 1234,
            transactionsCount = 50,
            decimalPlaces = 1,
            currency = "INR"
        )
    )
    return accounts
}

fun formatBalance(account: Account<Number>): String {
    if (account.decimalPlaces != 0) {
        val formatSpecifier = "%.${account.decimalPlaces}f"
        val formattedBalance = String.format(formatSpecifier, account.balance.toDouble())
        return formattedBalance
    }
    return "${account.balance}"
}