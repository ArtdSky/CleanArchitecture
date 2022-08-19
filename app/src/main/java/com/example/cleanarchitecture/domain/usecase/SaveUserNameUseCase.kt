package com.example.cleanarchitecture.domain.usecase;

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

public class SaveUserNameUseCase(private val userRepository : UserRepository) {

    fun execute(param : SaveUserNameParam) : Boolean{
        val result: Boolean = userRepository.saveName(saveparam = param)
        return result
    }
}
