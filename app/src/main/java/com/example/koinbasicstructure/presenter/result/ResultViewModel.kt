package com.example.koinbasicstructure.presenter.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {

    sealed class ResultAction {
        data class ShowView(val cep: String, val neighborhood: String, val street: String, val localization: String): ResultAction()
        object BackHome: ResultAction()
    }

    internal val action = MutableLiveData<ResultAction>()

    fun getArgs(args: ResultFragmentArgs) {
        action.value = ResultAction.ShowView(args.cepModel.cep, args.cepModel.bairro, args.cepModel.rua, args.cepModel.localidade)
    }

    fun backToHome() {
        action.value = ResultAction.BackHome
    }
}