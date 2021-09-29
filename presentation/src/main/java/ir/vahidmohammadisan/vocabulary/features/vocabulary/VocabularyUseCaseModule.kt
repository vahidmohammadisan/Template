package ir.vahidmohammadisan.vocabulary.features.vocabulary

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ir.vahidmohammadisan.domain.model.Vocabs
import ir.vahidmohammadisan.domain.usecase.UseCase
import ir.vahidmohammadisan.domain.usecase.vocabulary.GetVocabularyUseCase
import ir.vahidmohammadisan.domain.usecase.vocabulary.SaveVocabularyUseCase
import kotlinx.coroutines.flow.Flow

@Module
@InstallIn(ViewModelComponent::class)
abstract class VocabularyUseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun provideGetVocabularyUseCase(
        getVocabularyUseCase: GetVocabularyUseCase
    ): UseCase<Unit, Flow<List<Vocabs>>>

    @Binds
    @ViewModelScoped
    abstract fun provideSaveVocabularyUseCase(
        saveVocabularyUseCase: SaveVocabularyUseCase
    ): UseCase<Vocabs, Unit>
}