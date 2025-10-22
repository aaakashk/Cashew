package com.example.cashew.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cashew.ui.theme.ActiveSelectionColor
import com.example.cashew.ui.theme.TileBackGroundColor

@Composable
fun TransactionSegmentedButton() {
    val buttons = listOf("All", "Outgoing", "Incoming")
    var selectedIndex by remember { mutableIntStateOf(0) }

    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(48.dp)
            .background(TileBackGroundColor)
    ) {
        buttons.forEachIndexed { index, label ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { selectedIndex = index },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = if (selectedIndex == index) RoundedCornerShape(16.dp) else RoundedCornerShape(
                    0.dp
                ),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = ActiveSelectionColor,
                    activeContentColor = Color.White,
                    inactiveContainerColor = TileBackGroundColor,
                    inactiveContentColor = Color.Gray,
                    activeBorderColor = Color.Transparent,
                    inactiveBorderColor = Color.Transparent,
                ),
                icon = {},
            ) {
                Text(text = label)
            }
        }
    }

    Text(text = "Selected button: ${buttons[selectedIndex]}")
}