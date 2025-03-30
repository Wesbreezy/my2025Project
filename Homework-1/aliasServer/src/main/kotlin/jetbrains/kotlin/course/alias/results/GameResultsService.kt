package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import jetbrains.kotlin.course.util.getTeamById

@Service
class GameResultsService(
    private val gameResultRepository: GameResultRepository,
    private val teamService: TeamService
) {

    fun saveGameResults(result: GameResult) {
        require(result.teams.isNotEmpty()) { "Result cannot be empty" }
        require(result.teams.all { teamService.getTeamById(it.id!!) != null }) {
            "Team ID not found in storage"
        }
        gameResultRepository.save(result)
    }

    fun getAllGameResults(): List<GameResult> =
        gameResultRepository.findAll().reversed()
}