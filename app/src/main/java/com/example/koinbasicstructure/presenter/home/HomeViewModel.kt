package com.example.koinbasicstructure.presenter.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinbasicstructure.domain.models.CepModel
import com.example.koinbasicstructure.domain.useCases.GetCepUserCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getCepUserCase: GetCepUserCase) : ViewModel() {

    sealed class HomeAction {
        data class OpenResultView(val data: CepModel): HomeAction()
        object ApiFail: HomeAction()
    }

    sealed class HomeLoading {
        object LoadingOn : HomeLoading()
        object LoadingOff : HomeLoading()
    }

    internal val action = MutableLiveData<HomeAction>()
    internal val actionLoading = MutableLiveData<HomeLoading>()
    var textCep = ""

    fun getCep(valueCep: String) {
        textCep = valueCep
    }

    fun clickToSearchCep() {
        actionLoading.value = HomeLoading.LoadingOn
        viewModelScope.launch {
            kotlin.runCatching { getCepUserCase(textCep) }
                .onSuccess {
                    actionLoading.value = HomeLoading.LoadingOff
                    action.value = HomeAction.OpenResultView(it)
                }
                .onFailure {
                    actionLoading.value = HomeLoading.LoadingOff
                    action.value = HomeAction.ApiFail
                }
        }
    }
}