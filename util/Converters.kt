package jetbrains.kotlin.course.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameJsResult
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

// Convert a Card entity to a JsCard DTO
fun Card.toJsCard(): JsCard = JsCard(id, words.map { it.word }.toTypedArray())

// Convert a Team entity to a JsTeam DTO
fun Team.toJsTeam(): JsTeam = JsTeam(id = this.id!!, points = this.points, name = this.name)

// Convert a list of Teams to an array of JsTeam DTOs
fun List<Team>.toArrayJsTeams(): Array<JsTeam> = map { it.toJsTeam() }.toTypedArray()

// Convert a GameJsResult (frontend DTO) to a GameResult (backend entity)
fun GameJsResult.toGameResult(teamService: TeamService): GameResult {
    // Map each JsTeam to a Team entity, updating points and retrieving from the database
    val teams = this.map {
        // Retrieve the team from the database using TeamService
        val team = teamService.getTeamById(it.id.toLong()) ?: error("Unknown team ID: ${it.id}")
        team.points = it.points // Update the team's points
        team
    }
    // Wrap the list of teams in a GameResult entity
    return GameResult(teams = teams)
}

// Helper extension function for TeamService
fun TeamService.getTeamById(id: Long): Team? {
    return this.getAllTeams().find { it.id == id }
}