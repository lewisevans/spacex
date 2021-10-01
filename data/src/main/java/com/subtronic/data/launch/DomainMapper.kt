package com.subtronic.data.launch

import com.subtronic.data.api.entity.LaunchItemDataEntity
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import java.util.*

// TODO// Don't use java.util.Date
fun LaunchItemDataEntity.toDomain() = LaunchItemDataDomainEntity(
    name = name ?: "No name provided",
    launchDate = dateUtc ?: Date(0),
    success = success?.let { if (it) "True" else "False" } ?: "False",
    image = links?.patch?.small ?: "",
)