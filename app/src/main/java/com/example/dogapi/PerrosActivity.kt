package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_perros.*
import kotlin.concurrent.thread

class PerrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perros)
        val tag = "com.example.dogapi.perros.perro"
        val id:String = intent.getStringExtra(tag)
        txtPerro.text = "Raza de Perro: ".plus(id)
        val imagen = "https://dog.ceo/api/breed/".plus(id).plus("/images/random")


        if (Network.hayRed(this)) {
            var perros: ArrayList<Perro> = ArrayList()
            perros.add(Perro(id, imagen))
            perros.add(Perro(id, imagen))
            perros.add(Perro(id, imagen))
            perros.add(Perro(id, imagen))
            perros.add(Perro(id, imagen))
            val adaptador = AdaptadorCustom(this, perros)
            lista.adapter = adaptador
        }
    }
}
