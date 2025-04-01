package jetbrains.kotlin.course.alias.card

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()

    companion object {
        const val WORDS_IN_CARD = 4


        val words = jetbrains.kotlin.course.alias.util.words.toList()

        val cardsAmount: Int get() = words.size / WORDS_IN_CARD
    }

    private fun List<String>.toWords(): List<Word> = map { Word(it) }

    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        return shuffledWords.chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .map { Card(identifierFactory.uniqueIdentifier(), it.toWords()) }
    }

    val cards: List<Card> = generateCards()

    fun getCardByIndex(index: Int): Card =
        cards.getOrNull(index) ?: throw IllegalArgumentException("Card not found")
}