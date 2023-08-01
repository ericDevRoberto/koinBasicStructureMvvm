package com.example.koinbasicstructure.data.repositories

import com.example.koinbasicstructure.data.dataSource.GetCepDataSource
import com.example.koinbasicstructure.data.mappers.mapper
import com.example.koinbasicstructure.domain.models.CepModel
import com.example.koinbasicstructure.domain.repositories.GetCepRepository

class GetCepRepositoryImpl(private val dataSource: GetCepDataSource): GetCepRepository {
    override suspend fun getCep(cep: String): CepModel {
        return dataSource.getCepInformation(cep).mapper()
    }
}