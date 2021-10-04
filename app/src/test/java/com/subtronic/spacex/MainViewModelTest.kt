package com.subtronic.spacex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.GetFalconNineLaunchesUseCase
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.internal.verification.VerificationModeFactory
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: MainViewModel

    @MockK
    lateinit var useCase: GetFalconNineLaunchesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MainViewModel(useCase)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `GIVEN I want a list of launches WHEN getFalconNineLaunches is called THEN Loading is the first emitted value followed by Content`() {
        coEvery { useCase.execute() } answers { DomainResponse.Content(emptyList()) }
        val loading = viewModel.falconNineLaunches.getOrAwaitValue()
        assertEquals(loading, DomainResponse.Loading)
        val result = viewModel.falconNineLaunches.getOrAwaitValue()
        assertEquals(result, DomainResponse.Content(emptyList<LaunchItemDataDomainEntity>()))
        VerificationModeFactory.noMoreInteractions()
    }

    @Test
    fun `GIVEN I want a list of launches WHEN getFalconNineLaunches is called AND there is an error returned THEN Loading is the first emitted value followed by Error`() {
        coEvery { useCase.execute() } answers { DomainResponse.Error(222, "Error") }
        val loading = viewModel.falconNineLaunches.getOrAwaitValue()
        assertEquals(loading, DomainResponse.Loading)
        val result = viewModel.falconNineLaunches.getOrAwaitValue()
        assertEquals(result, DomainResponse.Error(222, "Error"))
    }
}