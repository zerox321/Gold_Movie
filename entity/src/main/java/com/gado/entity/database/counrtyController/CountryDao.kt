package com.gado.entity.database.counrtyController

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/** A data access object about the [CountryEntity] entity. */
@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<CountryEntity>)


    @Query("SELECT * FROM CountryEntity WHERE id = :id_")
    fun getItem(id_: Int): CountryEntity

    @Query("SELECT * FROM CountryEntity ")
    fun getList(): LiveData<List<CountryEntity>>

    @Query("DELETE  FROM CountryEntity")
    fun deleteDb()
}
