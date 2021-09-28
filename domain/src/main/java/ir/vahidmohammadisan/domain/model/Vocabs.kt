package ir.vahidmohammadisan.domain.model

data class Vocabs(
    val word:String,
    val type:VocabularyType,
    val sentenceOne:String,
    val sentenceTwo:String,
    val sentenceThree:String,
)