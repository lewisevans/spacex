package com.subtronic.domain.launch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.subtronic.data.launch.LaunchRepositoryImpl
import com.subtronic.domain.base.DomainResponse
import com.subtronic.spacex.TestCoroutineRule
import com.subtronic.spacex.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetFalconNineLaunchesUseCaseTest {

    @MockK
    private lateinit var repo: LaunchRepository

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var getFalconNineLaunchesUseCase: GetFalconNineLaunchesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getFalconNineLaunchesUseCase = GetFalconNineLaunchesUseCase(repo)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `GIVEN I want a list of launches WHEN getFalconNineLaunches is called THEN Content is emitted`() {
        testCoroutineRule.runBlockingTest {
            coEvery { repo.getFalconNineLaunches() } answers { DomainResponse.Content(emptyList()) }
            val result = getFalconNineLaunchesUseCase.execute()
            assertEquals(result, DomainResponse.Content(emptyList<LaunchItemDataDomainEntity>()))
        }
    }

    @Test
    fun `GIVEN I want a list of launches WHEN getFalconNineLaunches is called AND ann error occurs THEN Error is emitted`() {
        testCoroutineRule.runBlockingTest {
            coEvery { repo.getFalconNineLaunches() } answers { DomainResponse.Error(222, "Error") }
            val result = getFalconNineLaunchesUseCase.execute()
            assertEquals(result, DomainResponse.Error(222, "Error"))
        }
    }
}