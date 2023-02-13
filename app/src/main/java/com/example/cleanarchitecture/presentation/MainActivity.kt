package com.example.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity Created")

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)


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