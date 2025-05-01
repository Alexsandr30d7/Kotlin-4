package com.example.top.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.top.data.Club

@Composable
fun ClubCard(club: Club, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(Color(red = 128, green = 187, blue = 103, alpha = 164))
    ) {
        Row {
            Image(
                painter = painterResource(id = club.image),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(start = 20.dp),
                Alignment.CenterStart


            )
            Text(
                text = club.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp).align(Alignment.CenterVertically).fillMaxWidth(0.5f),

                )
        }
    }
}