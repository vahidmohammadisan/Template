package ir.vahidmohammadisan.domain.usecase.vocabulary

import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.repository.VocabularyRepository
import ir.vahidmohammadisan.domain.usecase.UseCase
import javax.inject.Inject

class SaveVocabularyUseCase @Inject constructor(private val vocabularyRepository: VocabularyRepository) :
    UseCase<@JvmSuppressWildcards Vocabs, Unit> {
    override fun execute(params: Vocabs) {
        vocabularyRepository.saveVocabulary(params)
    }
}