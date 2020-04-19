package com.example.dogapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBuscar.setOnClickListener{
            val tag = "com.example.dogapi.perros.perro"
            val intent = Intent( this, PerrosActivity::class.java)
            val perro = txtBuscar.text.toString()
            intent.putExtra(tag, perro)
            startActivity(intent)
        }
    }
}
