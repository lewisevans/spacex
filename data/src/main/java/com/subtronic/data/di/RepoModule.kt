package com.subtronic.data.di

import com.subtronic.data.launch.LaunchRepositoryImpl
import com.subtronic.domain.launch.LaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindItemRepository(
        repositoryImpl: LaunchRepositoryImpl
    ): LaunchRepository

}

