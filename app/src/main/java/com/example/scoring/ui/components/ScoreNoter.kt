package com.example.scoring.ui.components

import androidx.compose.foundation.layout.Arrangement
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
import com.example.scoring.ui.theme.ScoringTheme

@Composable
fun ScoreNote(
    name: String,
    score: Int,
    onPlusCLick: () -> Unit = {},
    onMinusCLick: () -> Unit = {}
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(6.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name)// First letter to uppercase ?
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "+"
                )
            }
            Text(
                text = score.toString(),
                modifier = Modifier.padding(horizontal = 8.dp)
                )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "-")
            }
        }
    }
}

@Preview
@Composable
fun ScoreNotePreview(){
    ScoringTheme {
        Surface {
            ScoreNote("Javier", 5)
        }
    }
}