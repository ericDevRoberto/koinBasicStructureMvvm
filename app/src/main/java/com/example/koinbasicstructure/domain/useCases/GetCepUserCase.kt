package com.example.koinbasicstructure.domain.useCases

import com.example.koinbasicstructure.domain.models.CepModel
import com.example.koinbasicstructure.domain.repositories.GetCepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCepUserCase(private val repository: GetCepRepository) {
    suspend operator fun invoke(cep: String): CepModel {
        return withContext(Dispatchers.IO) {
            repository.getCep(cep)
        }
    }
}