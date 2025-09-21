package com.example.cashew.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountsList(modifier: Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        content = {
            items(getAccounts()) { account ->
                Account(account = account)
            }
        }
    )
}

@Preview
@Composable
fun PreviewAccounts() {
    AccountsList(modifier = Modifier)
}

@Composable
fun Account(account: Account<Number>) {
    val shape = RoundedCornerShape(8.dp)
    Column(
        modifier = Modifier
            .clip(shape = shape)
            .then(
                if (account.isPrimary) {
                    Modifier.border(width = 1.dp, color = Color.Red, shape = shape)
                } else {
                    Modifier
                }
            )
            .background(Color.White)
            .padding(all = 8.dp)
    ) {
        Text(text = account.name)
        Text(
            text = formatBalance(account = account)
        )
        Text(text = "${account.transactionsCount} transactions")
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
        return "$formattedBalance ${account.currency}"
    }
    return "${account.balance} ${account.currency}"
}