package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
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