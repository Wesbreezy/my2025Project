package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        return (1..teamsNumber).map {
            val team = Team()
            teamRepository.save(team)
        }
    }

    fun getAllTeams(): List<Team> =
        teamRepository.findAll()
}