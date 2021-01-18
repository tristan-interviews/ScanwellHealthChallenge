package io.tristanlarsin.scanwellhealthchallenge.repositorys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module

object DataRepository {


    private val charset by lazy {
        ('a'..'z') + ('A'..'Z') + ('0'..'9')
    }

    private val _currentRandomString = MutableLiveData<String?>()

    val currentRandomString: LiveData<String?>
        get() = _currentRandomString

    init {
        _currentRandomString.value = null
    }

    fun generateRandomString() {
        _currentRandomString.value = getRandomString()
    }

    private fun getRandomString(length: Int = 10) =
        List(length) { charset.random() }.joinToString("")
}