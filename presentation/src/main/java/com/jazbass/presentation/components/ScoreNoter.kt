package com.jazbass.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jazbass.presentation.theme.ScoringTheme

@Composable
fun ScoreNote(
    name: String,
    score: MutableIntState,
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
        Counter(score = score)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ScoreNotePreview(){
    ScoringTheme {
        Surface {
            ScoreNote("Javier", mutableIntStateOf(5))
        }
    }
}