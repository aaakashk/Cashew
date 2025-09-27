package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Preview() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GreetingCard()
        AccountsRow()
        ExpensesAndIncomeTileRow()
        UpcomingAndOverdueTileRow()
        LentAndBorrowedTileRow()
        NetWorthTileRow()
        TransactionSegmentedButton()
    }
}