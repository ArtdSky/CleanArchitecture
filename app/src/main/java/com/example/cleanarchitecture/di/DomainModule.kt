package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module



val domainModule = module {

    factory<GetUserNameUseCase>{
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase>{
        SaveUserNameUseCase(userRepository = get())
    }





}