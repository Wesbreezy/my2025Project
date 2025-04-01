package jetbrains.kotlin.course.alias.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.results.GameJsResult
import jetbrains.kotlin.course.alias.results.GameResult
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

fun Card.toJsCard(): JsCard = JsCard(id, words.map { it.word }.toTypedArray())

fun Team.toJsTeam(): JsTeam = JsTeam(id = this.id!!, points = this.points, name = this.name)

fun List<Team>.toArrayJsTeams(): Array<JsTeam> = map { it.toJsTeam() }.toTypedArray()

fun GameJsResult.toGameResult(teamService: TeamService): GameResult {

    val teams = this.map {

        val team = teamService.getTeamById(it.id.toLong()) ?: error("Unknown team ID: ${it.id}")
        team.points = it.points
        team
    }

    return GameResult(teams = teams)
}

fun TeamService.getTeamById(id: Long): Team? {
    return this.getAllTeams().find { it.id == id }
}