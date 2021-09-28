package ir.vahidmohammadisan.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.vahidmohammadisan.data.local.AppDatabase
import ir.vahidmohammadisan.data.local.VocabularyDao

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideVocabularyDao(database: AppDatabase): VocabularyDao {
        return database.vocabularyDao()
    }
}