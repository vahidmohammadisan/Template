package ir.vahidmohammadisan.domain.repository

import ir.vahidmohammadisan.domain.model.Vocabs
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    fun saveVocabulary(vocabs: Vocabs)
    fun getVocabulary(): Flow<List<Vocabs>>
}