package jetbrains.kotlin.course.alias.card

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/card")
    fun getCardByIndex(@RequestParam index: Int): jetbrains.kotlin.course.alias.card.JsCard =
        service.getCardByIndex(index).toJsCard()

    @CrossOrigin
    @GetMapping("/amount")
    fun getCardsAmount(): Int = CardService.cardsAmount
}
