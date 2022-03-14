package com.example.miappintegrador.retrofit

import com.example.miappintegrador.models.Producto
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("producto/")
    fun obtenerProductos(): Call<List<Producto>>

    @POST("producto/")
    fun publicarProducto (@Body producto: Producto?) : Call<Producto>

    @FormUrlEncoded
    @POST("producto/")
    fun publicarProducto2 (
        @Field("nombre")nombre:String,
        @Field("precio")precio:String,
        @Field("marca")marca:String,
        @Field("telefono")telefono:String,
        @Field("direccion")direccion:String,
        @Field("permuta")permuta:String,
        @Field("condicion")condicion:String,
        @Field("imagen")imagen:String
        ) : Call<Producto>
}

    //@GET("posts/{id}")
    //fun getPostById(@Path("id") id: Int): Call<Post>

