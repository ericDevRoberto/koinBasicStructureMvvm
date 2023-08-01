package com.example.koinbasicstructure.data.services

import com.example.koinbasicstructure.data.models.response.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCepService {
    @GET("{cep_info}/json/")
    suspend fun getCepInformation(@Path("cep_info") cep: String) : CepResponse
}