package com.example.miappintegrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.miappintegrador.models.Producto
import com.example.miappintegrador.retrofit.RetrofitUser
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PublicarProductoActivity : AppCompatActivity() {

    private var nombre: EditText? =null
    private var precio: EditText? =null
    private var marca: EditText? =null
    private var telefono: EditText? =null
    private var direccion: EditText? =null
    private var permuta: EditText? =null
    private var condicion: EditText? =null
    private var imagen: EditText? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicar_producto)
        nombre = findViewById<EditText>(R.id.nombre)
        precio = findViewById<EditText>(R.id.precio)
        marca = findViewById<EditText>(R.id.marca)
        telefono = findViewById<EditText>(R.id.telefono)
        direccion = findViewById<EditText>(R.id.direccion)
        permuta = findViewById<EditText>(R.id.permuta)
        condicion = findViewById<EditText>(R.id.condicion)
        imagen = findViewById<EditText>(R.id.imagen)
        val btPublicar = findViewById<Button>(R.id.buttonPublicar)
        btPublicar.setOnClickListener{
            agregarPublicacion ()
        }


    }

    fun agregarPublicacion (){
        var producto: Producto? = Producto(nombre?.text.toString(),
            precio?.text.toString(),
            marca?.text.toString(),
            telefono?.text.toString(),
            direccion?.text.toString(),
            permuta?.text.toString(),
            condicion?.text.toString(),
            imagen?.text.toString())

        RetrofitUser.instance.publicarProducto (producto).enqueue(object: Callback<Producto> {
            override fun onResponse(call: Call<Producto>?, response: Response<Producto>?) {
                Log.i("producto", Gson().toJson(response?.body()))
            }
            override fun onFailure(call: Call<Producto>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}