package ir.vahidmohammadisan.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.vahidmohammadisan.domain.model.Vocabs

@Entity
data class VocabsEntity(
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "sentenceOne") val sentenceOne: String,
    @ColumnInfo(name = "sentenceTwo") val sentenceTwo: String,
    @ColumnInfo(name = "sentenceThree") val sentenceThree: String
){

    companion object {
        fun from(vocabs: Vocabs) = with(vocabs) {
            VocabsEntity(
                word,
                type,
                sentenceOne,
                sentenceTwo,
                sentenceThree)
        }
    }

    fun toVocabs() = Vocabs(
        word,
        type,
        sentenceOne,
        sentenceTwo,
        sentenceThree
    )
}
