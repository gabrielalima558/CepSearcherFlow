package com.example.cepsearcherflow.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cepsearcherflow.R

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this,
            ViewModelFactory
        ).get(
            MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getAddress("06086070")
        viewModel.cep.observe(this, Observer {
            Toast.makeText(
                this,
                "${it.cep}, ${it.bairro}, ${it.complemento}, ${it.localidade}",
                Toast.LENGTH_LONG
            ).show()
        })
    }
}