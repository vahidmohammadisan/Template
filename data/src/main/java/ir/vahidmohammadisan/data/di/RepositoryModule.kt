package ir.vahidmohammadisan.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.vahidmohammadisan.data.repository.VocabularyRepositoryImp
import ir.vahidmohammadisan.domain.repository.VocabularyRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindVocabularyRepository(
        vocabularyRepositoryImp: VocabularyRepositoryImp
    ): VocabularyRepository

}
