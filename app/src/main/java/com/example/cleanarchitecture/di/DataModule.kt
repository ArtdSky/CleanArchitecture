package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module



val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }




}