package com.jazbass.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jazbass.domain.PlayerBusiness
import com.jazbass.presentation.theme.ScoringTheme

@Composable
fun ScoreNote(
    player: PlayerBusiness
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = player.name)// First letter to uppercase ?
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { player.decreaseScore() }) {
                Text(text = "-")
            }
            Text(
                text = player.actualScore.value.toString(),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Button(onClick = { player.increaseScore() }) {
                Text(text = "+")
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ScoreNotePreview() {
    ScoringTheme {
        Surface {
            ScoreNote(PlayerBusiness(0, "Javier", 0, 0))
        }
    }
}