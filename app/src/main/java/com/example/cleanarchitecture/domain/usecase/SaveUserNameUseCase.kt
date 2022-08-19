package com.example.cleanarchitecture.domain.usecase;

import com.example.cleanarchitecture.domain.models.SaveUserNameParam

public class SaveUserNameUseCase {

    fun execute(param : SaveUserNameParam) : Boolean{
        if(param.name.isEmpty()){
            return false
        } else {
            return true
        }
    }
}
