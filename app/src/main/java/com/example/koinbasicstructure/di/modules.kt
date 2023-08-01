package com.example.koinbasicstructure.di

import com.example.koinbasicstructure.core.apiCoreService
import com.example.koinbasicstructure.data.dataSource.GetCepDataSource
import com.example.koinbasicstructure.data.repositories.GetCepRepositoryImpl
import com.example.koinbasicstructure.data.services.GetCepService
import com.example.koinbasicstructure.domain.repositories.GetCepRepository
import org.koin.dsl.module


private const val URL_CEP = "https://viacep.com.br/ws/"

val apiModules = module {
    single { apiCoreService(URL_CEP, GetCepService::class.java) }
    single { GetCepDataSource(get()) }
    single <GetCepRepository>{ GetCepRepositoryImpl(get()) }
}