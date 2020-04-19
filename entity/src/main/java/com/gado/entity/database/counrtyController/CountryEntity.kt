package com.gado.entity.database.counrtyController

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CountryEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val country_name: String?
)
