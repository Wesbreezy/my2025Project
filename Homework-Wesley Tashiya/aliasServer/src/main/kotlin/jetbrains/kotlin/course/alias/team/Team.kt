package jetbrains.kotlin.course.alias.team

import javax.persistence.*
import java.util.UUID

@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var points: Int = 0,

    @Column(nullable = false)
    val name: String = "Team#${UUID.randomUUID().toString().take(4)}"
)