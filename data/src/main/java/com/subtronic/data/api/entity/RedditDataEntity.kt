package com.subtronic.data.api.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RedditDataEntity(
    @Json(name = "campaign")
    val campaign: String?,
    @Json(name = "launch")
    val launch: String?,
    @Json(name = "media")
    val media: String?,
    @Json(name = "recovery")
    val recovery: Any?
)