package com.subtronic.spacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.subtronic.domain.base.DomainResponse
import com.subtronic.domain.launch.LaunchItemDataDomainEntity
import com.subtronic.spacex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding.mainViewRecycler) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
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
        mainAdapter.items = result
    }

    private fun weHaveAnError(message: String) {
        Log.d("Error", "We have an error: $message")
    }

    private fun weAreLoadingData() {
        binding.mainViewLoading.visibility = View.VISIBLE
    }
}