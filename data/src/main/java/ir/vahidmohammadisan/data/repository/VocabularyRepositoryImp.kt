package ir.vahidmohammadisan.data.repository

import ir.vahidmohammadisan.data.local.VocabularyDao
import ir.vahidmohammadisan.data.model.VocabsEntity
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VocabularyRepositoryImp @Inject constructor(private val vocabularyDao: VocabularyDao) :
    VocabularyRepository {
    override fun saveVocabulary(vocabs: Vocabs) {
        vocabularyDao.saveVocabulary(VocabsEntity.from(vocabs))
    }

    override fun getVocabulary(): Flow<List<Vocabs>> {
        return vocabularyDao.getVocabulary().map {
            it.map { item ->
                item.toVocabs()
            }
        }
    }
}