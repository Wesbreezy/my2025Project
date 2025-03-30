package jetbrains.kotlin.course.alias.team

import javax.persistence.*
import java.util.UUID

@Entity // Marks this class as a JPA entity
data class Team(
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    val id: Long? = null, // Unique team ID (auto-generated)

    var points: Int = 0, // Points start at 0

    @Column(nullable = false) // Ensures the column cannot be null
    val name: String = "Team#${UUID.randomUUID().toString().take(4)}" // Automatically generated team name (e.g., "Team#ABCD")
)