package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.e("AAA", "Activity Created")

        val dataTextView = findViewById<TextView>(R.id.tv_data)
        val dataEditView = findViewById<EditText>(R.id.text_edit)
        val sendButton = findViewById<Button>(R.id.button_send)
        val receiveButton = findViewById<Button>(R.id.button_receive)


        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text = text)

        }
        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}