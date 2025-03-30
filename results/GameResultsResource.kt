package jetbrains.kotlin.course.alias.results

import alias.JsTeam
import org.springframework.web.bind.annotation.*
import jetbrains.kotlin.course.alias.team.TeamService
import jetbrains.kotlin.course.util.toGameResult

class GameJsResult : ArrayList<JsTeam>()

@RestController
@RequestMapping("/api/results/")
class GameResultsResource(
    private val service: GameResultsService,
    private val teamService: TeamService
) {

    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult) {
        service.saveGameResults(result.toGameResult(teamService))
    }

    @CrossOrigin
    @GetMapping("/all")
    fun getAllGameResults() = service.getAllGameResults()
}