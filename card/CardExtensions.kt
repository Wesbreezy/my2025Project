package jetbrains.kotlin.course.alias.card

fun Card.toJsCard(): JsCard {
    return JsCard(
        id = this.id,
        words = this.words.map { it.word }.toTypedArray()
    )
}