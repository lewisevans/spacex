package com.subtronic.data.api.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaunchItemDataEntity(
    @field:Json(name = "auto_update") val autoUpdate: Boolean?,
    @field:Json(name = "capsules") val capsules: List<String>?,
    @field:Json(name = "cores") val cores: List<CoreDataEntity>?,
    @field:Json(name = "crew") val crew: List<Any>?,
    @field:Json(name = "date_local") val dateLocal: String?,
    @field:Json(name = "date_precision") val datePrecision: String?,
    @field:Json(name = "date_unix") val dateUnix: Int?,
    @field:Json(name = "date_utc") val dateUtc: String?,
    @field:Json(name = "details") val details: String?,
    @field:Json(name = "failures") val failures: List<Any>?,
    @field:Json(name = "fairings") val fairings: Any?,
    @field:Json(name = "flight_number") val flightNumber: Int?,
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "launchpad") val launchpad: String?,
    @field:Json(name = "links") val links: LinksDataEntity?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "net") val net: Boolean?,
    @field:Json(name = "payloads") val payloads: List<String>?,
    @field:Json(name = "rocket") val rocket: String?,
    @field:Json(name = "ships") val ships: List<Any>?,
    @field:Json(name = "static_fire_date_unix") val staticFireDateUnix: Int?,
    @field:Json(name = "static_fire_date_utc") val staticFireDateUtc: String?,
    @field:Json(name = "success") val success: Boolean?,
    @field:Json(name = "tdb") val tdb: Boolean?,
    @field:Json(name = "upcoming") val upcoming: Boolean?,
    @field:Json(name = "window") val window: Int?
)