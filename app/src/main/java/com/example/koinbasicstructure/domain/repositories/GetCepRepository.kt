package com.example.koinbasicstructure.domain.repositories

import com.example.koinbasicstructure.domain.models.CepModel

interface GetCepRepository {
    suspend fun getCep(cep: String) : CepModel
}