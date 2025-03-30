package jetbrains.kotlin.course.alias.results

import javax.persistence.*
import jetbrains.kotlin.course.alias.team.Team
import java.time.LocalDateTime

@Entity // Marks this class as a JPA entity
data class GameResult(
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    val id: Long? = null,

    @Column(nullable = false) // Ensures the column cannot be null
    val timestamp: LocalDateTime = LocalDateTime.now(), // Timestamp of the game result

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER) // One-to-many relationship with Team
    @JoinColumn(name = "game_result_id") // Foreign key column in the Team table
    val teams: List<Team> = emptyList() // List of teams in the game
)