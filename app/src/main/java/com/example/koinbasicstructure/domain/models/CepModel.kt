package com.example.koinbasicstructure.domain.models

data class CepModel(
    val cep: String,
    val rua: String,
    val bairro: String,
    val localidade: String,
) : java.io.Serializable
