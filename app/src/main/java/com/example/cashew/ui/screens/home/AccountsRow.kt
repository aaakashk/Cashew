package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.cashew.components.Tile
import com.example.cashew.domain.model.Account
import com.example.cashew.ui.viewmodels.AccountViewModel

@Composable
fun AccountsRow(viewModel: AccountViewModel = hiltViewModel()) {
    val accounts by viewModel.allAccounts.collectAsState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(accounts) { account ->
                Account(account = account)
            }
        }
    )
}

@Composable
fun Account(account: Account) {
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

fun formatBalance(account: Account): String {
    if (account.decimalPlaces != 0) {
        val formatSpecifier = "%.${account.decimalPlaces}f"
        val formattedBalance = String.format(formatSpecifier, account.balance.toDouble())
        return formattedBalance
    }
    return "${account.balance}"
}