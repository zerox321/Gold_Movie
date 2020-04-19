package com.gado.entity.database.respons

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class TrailerResponse(
    @Json(name = "id") val id: Int?,
    @Json(name = "results") val results: List<TrailerResponseResult>?
)

@Keep
data class TrailerResponseResult(
    @Json(name = "id") val id: String?,
    @Json(name = "key") val key: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "site") val site: String?,
    @Json(name = "size") val size: Int?,
    @Json(name = "type") val type: String?
)