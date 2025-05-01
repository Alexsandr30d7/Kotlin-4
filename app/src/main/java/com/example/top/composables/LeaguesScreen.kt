package com.example.top.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.top.data.League

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaguesScreen(
    leagues: List<League>,
    onLeagueClick: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Выберите Футбольную лигу") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(leagues) { league ->
                LeagueCard(league = league, onClick = { onLeagueClick(league.id) })
            }
        }
    }
}