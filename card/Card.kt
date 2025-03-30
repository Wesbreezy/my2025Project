package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier
import kotlinx.serialization.Serializable

@JvmInline // Required for value class compatibility
@Serializable
value class Word(val word: String)

@Serializable
data class Card(
    val id: Identifier,  // Unique card ID
    val words: List<Word> // List of words on the card
)