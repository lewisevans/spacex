package com.subtronic.data.api

import com.subtronic.data.api.entity.LaunchItemDataEntity
import retrofit2.http.GET

interface SpaceXApiService {

    @GET("launches")
    suspend fun getFalconNineLaunches(): List<LaunchItemDataEntity>

}