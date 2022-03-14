package com.example.miappintegrador

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miappintegrador.models.Producto
import com.squareup.picasso.Picasso

class productoadapter(val productos: List<Producto>): RecyclerView.Adapter<productoadapter.ViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater
                 .from(parent.context)
                 .inflate(R.layout.producto_view,parent, false)
         return ViewHolder(view)
     }

     override fun getItemCount(): Int {
         return productos.size
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val producto = productos[position]
         holder.bind(producto)
     }
     class ViewHolder (view:View):RecyclerView.ViewHolder(view){
         private val nombre = view.findViewById<TextView>(R.id.infonombre)
         private val precio = view.findViewById<TextView>(R.id.infoprecio)
         private val marca = view.findViewById<TextView>(R.id.infomarca)
         private val telefono = view.findViewById<TextView>(R.id.infotelefono)
         private val direccion = view.findViewById<TextView>(R.id.infodireccion)
         private val permuta = view.findViewById<TextView>(R.id.infopermuta)
         private val condicion = view.findViewById<TextView>(R.id.infocondicion)
         private val imagenproducto = view.findViewById<ImageView>(R.id.imagenProducto)

         fun bind (producto: Producto){
             nombre.text = "Nombre: "+producto.nombre
             precio.text = "Nombre: "+producto.precio
             marca.text = "Nombre: "+producto.marca
             telefono.text = "Nombre: "+producto.telefono
             direccion.text = "Nombre: "+producto.direccion
             permuta.text = "Nombre: "+producto.permuta
             condicion.text = "Nombre: "+producto.condicion
             Picasso.get().load(producto.imagen).into(imagenproducto)
         }

     }

 }


