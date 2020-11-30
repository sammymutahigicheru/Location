package com.sammy.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sammy.domain.models.*
import com.sammy.location.commons.showSnackbar
import com.sammy.location.databinding.ActivityMainBinding
import com.sammy.location.viewmodels.MainActivityViewModel
import okhttp3.MediaType
import okhttp3.RequestBody
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val locationViewModel by viewModel<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val request = LocationBodyRequest(
            MiataruConfig = MiataruConfig("6140c3c0-4a7d-40d2-99ab-39414cac3509"),
            MiataruGetLocation = listOf(MiataruGetLocation("7b8e6e0ee5296db345162dc2ef652c1350761823"))
        )
        locationViewModel.executeGetLocation(request)

        observeViewState()
    }

    private fun observeViewState() {
        locationViewModel.locationViewState.observe(this, { states ->
            if(states.isLoading){
                Log.d("MainActivity","******LOADING**********")
            }
            states.locationResults?.let { results ->
                binding.result.text = results.toString()

            }
            states.error?.run {
                binding.result.text = this.message
                Log.e("MainActivity","******ERROR ==>${this.message}<========**********")
            }

        })
    }
}