package com.example.cashew.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TotalsTile(
    type: String,
    amount: String,
    amountColor: Color = Color.White,
    transactionsCount: String,
    modifier: Modifier = Modifier,
) {
    Tile(modifier = modifier) {
        Text(
            text = type,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            text = amount,
            color = amountColor,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = "$transactionsCount transactions",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}