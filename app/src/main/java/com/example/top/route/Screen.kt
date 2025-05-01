package com.example.top.route

sealed class Screen(val route: String) {
    object Leagues : Screen("leagues")
    object Clubs : Screen("clubs/{leagueId}") {
        fun createRoute(leagueId: Int) = "clubs/$leagueId"
    }
    object ClubDetail : Screen("club/{clubId}") {
        fun createRoute(clubId: Int) = "club/$clubId"
    }
}