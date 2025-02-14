package com.example.country.model

import com.example.country.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryApi {
    @GET
    suspend fun getCountries(@retrofit2.http.Url url: String): List<Country>

    companion object {
        fun create(): CountryApi {
            return Retrofit.Builder()
                .baseUrl("https://restcountries.com/") // Base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryApi::class.java)
        }
    }
}

