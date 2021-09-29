package ir.vahidmohammadisan.vocabulary.features.vocabulary

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.usecase.vocabulary.GetVocabularyUseCase
import ir.vahidmohammadisan.domain.usecase.vocabulary.SaveVocabularyUseCase
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(
    private val getVocabularyUseCase: GetVocabularyUseCase,
    private val saveVocabularyUseCase: SaveVocabularyUseCase
) : ViewModel() {

    val vocabularyList : LiveData<List<Vocabs>> = getVocabularyUseCase.execute(Unit).asLiveData()

    fun insertVocabulary()=saveVocabularyUseCase.execute(Vocabs("vahid","salam","salam","salam","salam"))

}