package com.example.koinbasicstructure.di

import com.example.koinbasicstructure.core.apiCoreService
import com.example.koinbasicstructure.data.dataSource.GetCepDataSource
import com.example.koinbasicstructure.data.repositories.GetCepRepositoryImpl
import com.example.koinbasicstructure.data.services.GetCepService
import com.example.koinbasicstructure.domain.repositories.GetCepRepository
import com.example.koinbasicstructure.domain.useCases.GetCepUserCase
import com.example.koinbasicstructure.presenter.home.HomeViewModel
import com.example.koinbasicstructure.presenter.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


private const val URL_CEP = "https://viacep.com.br/ws/"

val apiModules = module {
    single { apiCoreService(URL_CEP, GetCepService::class.java) }
    single { GetCepDataSource(get()) }
    single <GetCepRepository>{ GetCepRepositoryImpl(get()) }
}

val domainModules = module {
    factory { GetCepUserCase(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ResultViewModel() }
}