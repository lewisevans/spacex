package com.subtronic.data.api.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PatchDataEntity(
    @Json(name = "large")
    val large: String?,
    @Json(name = "small")
    val small: String?
)