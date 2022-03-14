package com.example.miappintegrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.miappintegrador.models.Producto
import com.example.miappintegrador.retrofit.RetrofitUser
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class activity_clactivity : AppCompatActivity() {

    var listaproductos: ArrayList<Producto>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clactivity)


        RetrofitUser.instance.obtenerProductos().enqueue(object : retrofit2.Callback<List<Producto>> {

            override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                if (response!=null){

                    listaproductos= ArrayList<Producto>(response.body())
                    //Toast.makeText(applicationContext,response.body().toString(), Toast.LENGTH_LONG).show()
                    //Log.i("producto", Gson().toJson(listaproductos))
                    val recycler = findViewById<RecyclerView>(R.id.rvproductos)
                    recycler.adapter = productoadapter(listaproductos as ArrayList<Producto>)
                }
                else {
                    Log.i("sin productos","no hay datos ingresados")
                }
            }
            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Log.i("error","errorx2"+t.toString())

            }
        })
    }

}