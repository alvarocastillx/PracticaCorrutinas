package com.acasloa946.practicacorrutinas.userInterface

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Viewmodel1(application: Application): AndroidViewModel(application) {

    private val _backgroundColor = MutableLiveData<Color>()
    val backgroundColor: LiveData<Color> = _backgroundColor

    private val _contAPI = MutableLiveData<Int>()
    val contAPI: LiveData<Int> = _contAPI

    init {
        _backgroundColor.value = Color.Red
        _contAPI.value = 0
    }

    fun colorChanger() {
        if (_backgroundColor.value==Color.Red) {
            _backgroundColor.value=Color.Blue
        }
        else {
            _backgroundColor.value=Color.Red
        }
    }
    fun llamarAPI() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(5000)
            }
            _contAPI.value = _contAPI.value!! + 1
        }
    }

}