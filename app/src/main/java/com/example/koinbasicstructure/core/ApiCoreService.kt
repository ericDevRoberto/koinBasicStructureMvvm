package com.example.koinbasicstructure.core

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun<T> apiCoreService(url: String, serviceInterface:Class <T>): T {
val moshi =Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

    val builder = Retrofit.Builder()
        .baseUrl(url)
        .client(OkHttpClient().newBuilder().build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
    return builder.build().create(serviceInterface)

}