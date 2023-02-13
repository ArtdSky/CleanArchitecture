package com.example.cleanarchitecture.domain.usecase;

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository : UserRepository) {

    fun execute(param : SaveUserNameParam) : Boolean{
        val oldUserName = userRepository.getName()
        if(oldUserName.firstName == param.name){
            return true
        }

        return userRepository.saveName(saveParam = param)

    }
}
