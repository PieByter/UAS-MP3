package com.example.randomapps.api

import com.example.randomapps.api.ResponseRick
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("character")
    fun getRick(): Call<ResponseRick>
}