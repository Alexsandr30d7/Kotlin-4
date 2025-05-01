package com.example.top.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.top.data.Club
import com.example.top.data.League
import com.example.top.repository.PlacesRepository

class LeagueViewModel : ViewModel() {
    private val _leagues = mutableStateOf(emptyList<League>())
    val leagues: State<List<League>> = _leagues

    private val _clubs = mutableStateOf(emptyList<Club>())
    val clubs: State<List<Club>> = _clubs

    private val _selectedClub = mutableStateOf<Club?>(null)
    val selectedClub: State<Club?> = _selectedClub

    init {
        loadLeagues()
    }

    fun loadLeagues() {
        _leagues.value = PlacesRepository.getLeagues()
    }

    fun loadClubs(leagueId: Int) {
        _clubs.value = PlacesRepository.getClubByLeague(leagueId)
    }

    fun selectClub(clubId: Int) {
        _selectedClub.value = PlacesRepository.getClubById(clubId)
    }
}