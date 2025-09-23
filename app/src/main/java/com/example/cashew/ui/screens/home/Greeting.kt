package com.example.cashew.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.cashew.components.CustomCard
import com.example.cashew.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingCard() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val editNameViewModel = CardTextViewModel()
    var cardText by remember { mutableStateOf("Akash") }
    Column(
        modifier = Modifier
            .imePadding()
    ) {
        CustomCard(
            text = "Hi There",
            fontSize = 14.sp,
            color = PurpleGrey80,
        )
        CustomCard(text = cardText, onClick = { showBottomSheet = true })
    }

    if (showBottomSheet) {
        ModalBottomSheet(onDismissRequest = { showBottomSheet = false }, sheetState = sheetState) {
            EditNameWithViewModel(
                viewModel = editNameViewModel,
                onSave = {
                    cardText = it
                    showBottomSheet = false
                })
        }
    }
}