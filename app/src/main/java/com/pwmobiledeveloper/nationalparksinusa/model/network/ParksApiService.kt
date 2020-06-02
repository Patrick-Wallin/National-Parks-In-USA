package com.pwmobiledeveloper.nationalparksinusa.model.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

private const val BASE_URL = "https://developer.nps.gov/api/v1/"

private val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ParksApiService {
    companion object {
        val API_KEY = "jKq4zWClcooBMGr8iRtXUq2Ih6NrMbyTlkyDXJmd"
    }
    @GET("parks")
    suspend fun getParks(@Query("api_key") type: String, @Query("limit") limit: Int): NetworkPark
}

object ParksApi {
    val retrofitService : ParksApiService by lazy {
        retrofit.create(ParksApiService::class.java) }
}