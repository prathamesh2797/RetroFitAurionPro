package com.example.retrofitaurionpro.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitaurionpro.models.License
import com.example.retrofitaurionpro.models.jsonList
import com.example.retrofitaurionpro.repository.jsonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: jsonRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getData()
        }
    }

    val jsonData: LiveData<jsonList>
    get()= repository.json
}