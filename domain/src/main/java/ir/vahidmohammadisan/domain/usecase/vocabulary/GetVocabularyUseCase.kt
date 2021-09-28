package ir.vahidmohammadisan.domain.usecase.vocabulary

import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.repository.VocabularyRepository
import ir.vahidmohammadisan.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVocabularyUseCase @Inject constructor(private val vocabularyRepository: VocabularyRepository) :
    UseCase<Unit, Flow<List<Vocabs>>> {
    override fun execute(params: Unit): Flow<List<Vocabs>> {
        return vocabularyRepository.getVocabulary()
    }
}