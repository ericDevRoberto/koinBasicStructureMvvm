package com.example.koinbasicstructure.data.mappers

import com.example.koinbasicstructure.data.models.response.CepResponse
import com.example.koinbasicstructure.domain.models.CepModel

fun CepResponse.mapper(): CepModel = CepModel(
    cep,
    logradouro,
    bairro,
    localidade + "" + uf
)