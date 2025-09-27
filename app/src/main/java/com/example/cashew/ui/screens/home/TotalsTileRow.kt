package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cashew.components.TotalsTile
import com.example.cashew.ui.theme.Pink40
import com.example.cashew.ui.theme.Purple80

@Composable
fun ExpensesAndIncomeTileRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TotalsTile(
            type = "Expenses",
            amount = "1234.2323525262",
            amountColor = Pink40,
            transactionsCount = "12",
            modifier = Modifier.weight(1f),
        )
        TotalsTile(
            type = "Income",
            amount = "572921241415",
            amountColor = Color.Green,
            transactionsCount = "41",
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
fun LentAndBorrowedTileRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TotalsTile(
            type = "Lent",
            amount = "1234.23",
            amountColor = Color.Blue,
            transactionsCount = "11",
            modifier = Modifier.weight(1f),
        )
        TotalsTile(
            type = "Borrowed",
            amount = "57292",
            amountColor = Purple80,
            transactionsCount = "2",
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
fun UpcomingAndOverdueTileRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TotalsTile(
            type = "Upcoming",
            amount = "1234.2",
            amountColor = Color.Blue,
            transactionsCount = "12",
            modifier = Modifier.weight(1f),
        )
        TotalsTile(
            type = "Overdue",
            amount = "0",
            amountColor = Purple80,
            transactionsCount = "41",
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
fun NetWorthTileRow() {
    Row {
        TotalsTile(
            type = "Net Worth",
            amount = "12340.23",
            transactionsCount = "415",
            modifier = Modifier.weight(1f),
        )
    }
}
