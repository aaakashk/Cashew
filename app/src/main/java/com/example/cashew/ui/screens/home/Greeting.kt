package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cashew.components.CustomCard
import com.example.cashew.ui.theme.PurpleGrey80

@Composable
fun GreetingCard() {
    Column {
        CustomCard(
            text = "Hi There",
            fontSize = 14.sp,
            color = PurpleGrey80,
        )
        CustomCard(text = "Akash", onClick = {})
    }
}