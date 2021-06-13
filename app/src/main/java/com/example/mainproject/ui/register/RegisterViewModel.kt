package com.example.mainproject.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.db.DataBaseObject.db
import com.example.mainproject.data.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel : ViewModel() {

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

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

    fun write(user: User) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.userDao().insert(user)
                _isSuccessful.postValue(true)
            }
        }
    }

}