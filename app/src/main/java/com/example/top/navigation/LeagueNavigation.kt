package com.example.top.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.top.composables.ClubDetailScreen
import com.example.top.composables.ClubsScreen
import com.example.top.composables.LeaguesScreen
import com.example.top.route.Screen
import com.example.top.viewModel.LeagueViewModel

@Composable
fun LeagueNavigation(viewModel: LeagueViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Leagues.route) {
        composable(Screen.Leagues.route) {
            LeaguesScreen(
                leagues = viewModel.leagues.value,
                onLeagueClick = { leagueId ->
                    navController.navigate(Screen.Clubs.createRoute(leagueId))
                }
            )
        }

        composable(Screen.Clubs.route) { backStackEntry ->
            val leagueId = backStackEntry.arguments?.getString("leagueId")?.toIntOrNull() ?: 0
            viewModel.loadClubs(leagueId)

            ClubsScreen(
                clubs = viewModel.clubs.value,
                onClubClick = { clubId ->
                    navController.navigate(Screen.ClubDetail.createRoute(clubId))
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.ClubDetail.route) { backStackEntry ->
            val clubId = backStackEntry.arguments?.getString("clubId")?.toIntOrNull() ?: 0
            viewModel.selectClub(clubId)

            ClubDetailScreen(
                club = viewModel.selectedClub.value,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}