package com.subtronic.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(viewModel){
            getFalconNineLaunches().observe(this@MainActivity, {
                when(it){
                    is DomainResponse.Content -> {
                        weHaveContent(it.result)
                    }
                    is DomainResponse.Error -> {
                        weHaveAnError(it.message)
                    }
                    DomainResponse.Loading -> {
                        weAreLoadingData()
                    }
                }
            })
        }
    }

    private fun weHaveContent(result: List<LaunchItemDataDomainEntity>) {
        Log.d("Result", "We have a result: $result")
    }

    private fun weHaveAnError(message: String) {
        Log.d("Error", "We have an error: $message")
    }

    private fun weAreLoadingData() {
        Log.d("Loading", "I should show the loading spinner here")
    }
}