package com.subtronic.data.launch

import com.subtronic.data.domainResponse
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import com.subtronic.domain.launch.LaunchRepository
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val launchDataSource: LaunchDataSource
) : LaunchRepository {
    override suspend fun getFalconNineLaunches(): DomainResponse<List<LaunchItemDataDomainEntity>> =
        domainResponse {
            launchDataSource.getFalconNineLaunches().map { it.toDomain() }
        }

}


