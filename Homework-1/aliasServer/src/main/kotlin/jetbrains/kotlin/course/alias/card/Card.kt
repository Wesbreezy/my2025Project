package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class Word(val word: String)

@Serializable
data class Card(
    val id: Identifier,
    val words: List<Word>
)