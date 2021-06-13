package com.example.mainproject.ui.launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.network.RetrofitService.api
import com.example.mainproject.data.network.models.SpaceXLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LaunchViewModel : ViewModel() {

    private val _launches = MutableLiveData<List<SpaceXLaunch>>()
    val launches: LiveData<List<SpaceXLaunch>> = _launches

    fun getLaunches() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = api.getLaunches()

                _launches.postValue(response.body()!!)
            }
        }
    }

}