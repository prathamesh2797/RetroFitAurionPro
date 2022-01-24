package com.example.retrofitaurionpro.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitaurionpro.api.JsonAPI
import com.example.retrofitaurionpro.models.License
import com.example.retrofitaurionpro.models.jsonList
import com.example.retrofitaurionpro.models.jsonListItem

class jsonRepository(private var jsonApi: JsonAPI) {

    private val jsonLiveData = MutableLiveData<jsonList>()
    val json : LiveData<jsonList>
        get() = jsonLiveData


    suspend fun getData(){
        val result = jsonApi.getJsonList()
        if (result?.body() != null){
            jsonLiveData.postValue(result.body())
        }
    }
}