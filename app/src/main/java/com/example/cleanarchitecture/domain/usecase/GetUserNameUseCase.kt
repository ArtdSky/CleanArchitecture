package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Sarah", lastName = "Kerrigan")
    }
}