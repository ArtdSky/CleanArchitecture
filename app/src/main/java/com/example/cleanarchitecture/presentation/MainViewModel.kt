package com.example.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var stateLiveMutable = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = stateLiveMutable
    
    init {
        Log.e("AAA", "VM Cleared")
        stateLiveMutable.value = MainState(
            saveResult = false,
            firstName = "",
            lastName = ""
        )
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = result,
            firstName = stateLiveMutable.value!!.firstName,
            lastName = stateLiveMutable.value!!.lastName
        )
    }

    private fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }

}