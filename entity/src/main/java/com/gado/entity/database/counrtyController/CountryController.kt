package com.gado.entity.database.counrtyController

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryController(private val dao: CountryDao) {

//    suspend fun insertCountries(subject: List<CountryResponseData?>?) =
//        withContext(Dispatchers.IO) {
//            val products = subject!!.map {
//                CountryEntity(
//                    id = it?.country?.id!!,
//                    country_name = it.country.countryName
//                )
//            }
//            dao.insertList(products)
//        }

    fun getList() = dao.getList()
}