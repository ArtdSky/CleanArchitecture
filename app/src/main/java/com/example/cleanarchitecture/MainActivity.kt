package com.example.cleanarchitecture

import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv_data = findViewById<TextView>(R.id.tv_data)
        val button_receive = findViewById<Button>(R.id.button_receive)
        val text_edit = findViewById<EditText>(R.id.text_edit)
        val button_send = findViewById<Button>(R.id.button_send)

        button_send.setOnClickListener {
            val text = text_edit.text.toString()
            val params = SaveUserNameParam(name = text)
            val result : Boolean = saveUserNameUseCase.execute(param = params)
            tv_data.text = "save result = $result"

        }

        button_receive.setOnClickListener {
            val userName : UserName = getUserNameUseCase.execute()
            tv_data.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}