package ir.vahidmohammadisan.newtemplate.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.vahidmohammadisan.basic_feature.data.local.dao.RocketDao
import ir.vahidmohammadisan.basic_feature.data.local.model.RocketCached


private const val DATABASE_VERSION = 1

@Database(
    entities = [RocketCached::class],
    version = DATABASE_VERSION,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rocketDao(): RocketDao
}
