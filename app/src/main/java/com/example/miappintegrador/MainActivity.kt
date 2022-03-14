package com.example.miappintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val publicar = findViewById<Button>(R.id.agregar_publicacion)

        val publicaciones = findViewById<Button>(R.id.ver_publicaciones)

        val informacion = findViewById<Button>(R.id.advertencia)

        publicar.setOnClickListener{
            val intentpublica = Intent (this ,PublicarProductoActivity:: class.java)
            startActivity(intentpublica)

        }
        publicaciones.setOnClickListener{
            val intentpubli = Intent (this ,activity_clactivity:: class.java)
            startActivity(intentpubli)
        }
        informacion.setOnClickListener{
            val intentpublibli = Intent (this ,advertencia:: class.java)
            startActivity(intentpublibli)
        }

    }
}