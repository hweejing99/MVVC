package com.example.mvvc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    //mutable we can always assign new value to replace it
    //liveData will notify the changes during observation
    private val _count = MutableLiveData<Int>()

    val count: LiveData<Int>
    get() = _count// this is a getter

    //? means can be null
    fun increment(){
        _count.value = _count.value?.plus(1)
    }

    fun decrement(){
        _count.value = _count.value?.minus(1)
    }

    //var count: Int = 0
    //when create instance of ViewModel just initialize
    init{
        _count.value = 0
        Log.d("MVVC", "ViewModel initialized")
    }

    override fun onCleared() {
        Log.d("MVVC", "ViewModel cleared")
        super.onCleared()
    }
}