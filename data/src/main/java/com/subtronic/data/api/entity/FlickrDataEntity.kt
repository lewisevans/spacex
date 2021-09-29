package com.subtronic.data.api.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrDataEntity(
    @Json(name = "original")
    val original: List<String>?,
    @Json(name = "small")
    val small: List<Any>?
)