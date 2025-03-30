package jetbrains.kotlin.course.alias.results

import org.springframework.data.jpa.repository.JpaRepository

interface GameResultRepository : JpaRepository<GameResult, Long>