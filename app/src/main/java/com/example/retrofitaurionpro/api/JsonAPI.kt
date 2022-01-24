package com.example.retrofitaurionpro.api

import com.example.retrofitaurionpro.models.License
import com.example.retrofitaurionpro.models.jsonList
import com.example.retrofitaurionpro.models.jsonListItem
import retrofit2.Response
import retrofit2.http.GET

interface  JsonAPI {

    @GET("/orgs/square/repos")
    suspend fun getJsonList(): Response<jsonList>
}