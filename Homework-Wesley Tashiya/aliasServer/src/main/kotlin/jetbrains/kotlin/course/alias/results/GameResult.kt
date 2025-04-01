package jetbrains.kotlin.course.alias.results

import javax.persistence.*
import jetbrains.kotlin.course.alias.team.Team
import java.time.LocalDateTime

@Entity
data class GameResult(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "game_result_id")
    val teams: List<Team> = emptyList()
)