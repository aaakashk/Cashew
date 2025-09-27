package com.example.cashew.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cashew.ui.theme.Purple80

@Composable
fun CustomCard(
    text: String,
    fontSize: TextUnit = 28.sp,
    fontWeight: FontWeight = FontWeight.ExtraBold,
    color: Color = Purple80,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    val modifier = modifier
    val cardElevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    if (onClick == null) {
        Card(
            modifier = modifier,
            elevation = cardElevation
        ) {
            CardContent(text, fontSize, fontWeight, color)
        }
    } else {
        Card(
            modifier = modifier,
            elevation = cardElevation,
            onClick = onClick
        ) {
            CardContent(text, fontSize, fontWeight, color)
        }
    }
}

@Composable
private fun CardContent(text: String, fontSize: TextUnit, fontWeight: FontWeight, color: Color) {
    Column(modifier = Modifier) {
        Text(text = text, fontWeight = fontWeight, fontSize = fontSize, color = color)
    }
}