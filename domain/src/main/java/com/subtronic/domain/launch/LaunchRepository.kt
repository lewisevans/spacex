package com.subtronic.domain.launch

import com.subtronic.domain.base.DomainResponse

interface LaunchRepository {
    suspend fun getFalconNineLaunches(): DomainResponse<List<LaunchItemDataDomainEntity>>
}