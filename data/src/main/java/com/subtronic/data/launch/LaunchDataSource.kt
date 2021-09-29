package com.subtronic.data.launch

import com.subtronic.data.api.SpaceXApiService
import com.subtronic.data.api.entity.LaunchItemDataEntity
import javax.inject.Inject

class LaunchDataSource @Inject constructor(
    private val service: SpaceXApiService
) {
    suspend fun getFalconNineLaunches(): List<LaunchItemDataEntity> = service.getFalconNineLaunches()
}