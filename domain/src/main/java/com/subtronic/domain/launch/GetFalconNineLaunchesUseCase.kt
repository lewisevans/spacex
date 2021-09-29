package com.subtronic.domain.launch

import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.base.UseCase
import javax.inject.Inject

class GetFalconNineLaunchesUseCase @Inject constructor(
    private val repository: LaunchRepository
) : UseCase<List<LaunchItemDataDomainEntity>> {
    override suspend fun execute(): DomainResponse<List<LaunchItemDataDomainEntity>> =
        repository.getFalconNineLaunches()
}