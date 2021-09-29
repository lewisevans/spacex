package com.subtronic.data.api.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksDataEntity(
    @Json(name = "article")
    val article: String?,
    @Json(name = "flickr")
    val flickr: FlickrDataEntity?,
    @Json(name = "patch")
    val patch: PatchDataEntity?,
    @Json(name = "presskit")
    val presskit: String?,
    @Json(name = "reddit")
    val reddit: RedditDataEntity?,
    @Json(name = "webcast")
    val webcast: String?,
    @Json(name = "wikipedia")
    val wikipedia: String?,
    @Json(name = "youtube_id")
    val youtubeId: String?
)