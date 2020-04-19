package com.gado.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gado.entity.database.counrtyController.CountryDao
import com.gado.entity.database.counrtyController.CountryEntity


@Database(
    entities = [CountryEntity::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
