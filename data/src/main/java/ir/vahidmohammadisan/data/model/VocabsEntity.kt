package ir.vahidmohammadisan.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.vahidmohammadisan.domain.model.Vocabs

@Entity
data class VocabsEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "sentenceOne") val sentenceOne: String,
    @ColumnInfo(name = "sentenceTwo") val sentenceTwo: String,
    @ColumnInfo(name = "sentenceThree") val sentenceThree: String
) {
    fun List<VocabsEntity>.asDomainModel(): List<Vocabs> {
        return map {
            Vocabs(
                word = it.word,
                type = it.type,
                sentenceOne = it.sentenceOne,
                sentenceTwo = it.sentenceTwo,
                sentenceThree = it.sentenceThree
            )
        }
    }

}
