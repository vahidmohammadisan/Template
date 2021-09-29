package ir.vahidmohammadisan.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.vahidmohammadisan.data.model.VocabsEntity
import ir.vahidmohammadisan.domain.model.Vocabs
import kotlinx.coroutines.flow.Flow

@Dao
interface VocabularyDao {

    @Query("SELECT * FROM VocabsEntity")
    fun getVocabulary(): Flow<List<VocabsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveVocabulary(vocabsEntity: VocabsEntity)
}
