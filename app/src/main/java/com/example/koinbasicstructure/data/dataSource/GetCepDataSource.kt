package com.example.koinbasicstructure.data.dataSource

import com.example.koinbasicstructure.data.models.response.CepResponse
import com.example.koinbasicstructure.data.services.GetCepService

class GetCepDataSource(private val service: GetCepService) {
    suspend fun getCepInformation(cep: String): CepResponse {
        return try {
            service.getCepInformation(cep)
        } catch (e: Throwable) {
            throw e
        }
    }
}