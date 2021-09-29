package ir.vahidmohammadisan.vocabulary.features.vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.usecase.vocabulary.GetVocabularyUseCase
import ir.vahidmohammadisan.domain.usecase.vocabulary.SaveVocabularyUseCase
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(
    private val getVocabularyUseCase: GetVocabularyUseCase,
    private val saveVocabularyUseCase: SaveVocabularyUseCase
) : ViewModel() {

    val vocabularyList = liveData {
        val vocabularyList = getVocabularyUseCase.execute(Unit)
        emit(vocabularyList)
    }

    fun insertVocabulary()=saveVocabularyUseCase.execute(Vocabs("anita","salam","salam","salam","salam"))

}