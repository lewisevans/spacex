package com.subtronic.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import com.subtronic.spacex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(viewModel){
            falconNineLaunches.observe(this@MainActivity, {
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
        binding.mainViewLoading.visibility = View.INVISIBLE
    }

    private fun weHaveAnError(message: String) {
        Log.d("Error", "We have an error: $message")
    }

    private fun weAreLoadingData() {
        binding.mainViewLoading.visibility = View.VISIBLE
    }
}