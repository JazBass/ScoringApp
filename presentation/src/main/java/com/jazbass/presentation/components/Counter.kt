package com.jazbass.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Counter(
    score: MutableIntState,
    minimumValue: Int? = null,
    maximumValue: Int? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Button(onClick = { minimumValue.let { score.intValue-- } }) {
            Text(text = "-")
        }
        Text(
            text = score.value.toString(),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Button(onClick = { score.intValue++ }) {
            Text(text = "+")
        }
    }
}