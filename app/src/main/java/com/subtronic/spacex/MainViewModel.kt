package com.subtronic.spacex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.GetFalconNineLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFalconNineLaunchesUseCase: GetFalconNineLaunchesUseCase
) : ViewModel() {

    fun getFalconNineLaunches() = liveData {
        emit(DomainResponse.Loading)
        emit(getFalconNineLaunchesUseCase.execute())
    }

}