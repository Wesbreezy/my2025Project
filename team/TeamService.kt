package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.team.TeamRepository

@Service
class TeamService(
    private val teamRepository: TeamRepository // Inject TeamRepository
) {

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        return (1..teamsNumber).map {
            val team = Team() // Create a new team
            teamRepository.save(team) // Save the team to the database
        }
    }

    fun getAllTeams(): List<Team> =
        teamRepository.findAll() // Fetch all teams from the database
}