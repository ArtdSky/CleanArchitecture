package com.example.cleanarchitecture.presentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.sharedrefs.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val vm by viewModel<MainViewModel>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            Log.e("AAA", "Activity Created")



            val tv_data = findViewById<TextView>(R.id.tv_data)
            val button_receive = findViewById<Button>(R.id.button_receive)
            val text_edit = findViewById<EditText>(R.id.text_edit)
            val button_send = findViewById<Button>(R.id.button_send)

            vm.resultLive.observe(this, Observer {
                tv_data.text = it
            })

            button_send.setOnClickListener {
                val text = tv_data.text.toString()
                vm.save(text)

            }

            button_receive.setOnClickListener {
                vm.load()
            }
        }
}