// jetbrains.kotlin.course.alias.card/CardService.kt
package jetbrains.kotlin.course.alias.card

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words // Import the provided words

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()

    companion object {
        const val WORDS_IN_CARD = 4

        // Convert the Set of words to a List for shuffling
        val words = jetbrains.kotlin.course.alias.util.words.toList()

        // Calculate the number of cards (integer division)
        val cardsAmount: Int get() = words.size / WORDS_IN_CARD
    }

    // Converts a list of strings to a list of Word objects
    private fun List<String>.toWords(): List<Word> = map { Word(it) }

    // Generates shuffled cards
    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        return shuffledWords.chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .map { Card(identifierFactory.uniqueIdentifier(), it.toWords()) }
    }

    // Public property to access all cards
    val cards: List<Card> = generateCards()

    // Retrieves a card by index (throws error if not found)
    fun getCardByIndex(index: Int): Card =
        cards.getOrNull(index) ?: throw IllegalArgumentException("Card not found")
}