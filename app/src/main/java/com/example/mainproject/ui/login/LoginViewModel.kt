package com.example.mainproject.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.db.DataBaseObject.db
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _usersCount = MutableLiveData<Int>()
    val usersCount: LiveData<Int> = _usersCount

    fun checkEmail(email: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val count = db.userDao().findByEmail(email)
                _usersCount.postValue(count)
            }
        }
    }
}
