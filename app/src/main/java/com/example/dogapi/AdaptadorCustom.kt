package com.example.dogapi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.template.view.*
import java.net.URI

class AdaptadorCustom (var context: Context, items:ArrayList<Perro>): BaseAdapter() {
    var items:ArrayList<Perro>? = null
    init{
        this.items = items
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = LayoutInflater.from(context).inflate(R.layout.template,null)
        var holder = ViewHolder(vista)
        vista.tag=holder
        val item = getItem(position) as Perro
        Log.d("UrlImagenPerro", item.imagen)
        solicitudHttpVolley(item.imagen, vista)
        return vista!!
    }
    private fun solicitudHttpVolley(url:String, holder:View){
        val queue = Volley.newRequestQueue(this.context)
        val solicitud = StringRequest(
            Request.Method.GET, url,
            Response.Listener <String> {
                    response ->
                try{
                    Log.d("SolicitudVolley", response)
                    val gson = Gson()
                    val imagen = gson.fromJson(response, Imagen::class.java)
                    Glide.with(this.context).load(imagen.message).into(holder.imagen)
                }
                catch (e: Exception){}
            },
            Response.ErrorListener {  }
        )
        queue.add(solicitud)
    }
    override fun getItem(position: Int): Any { return items?.get(position)!!
    }
    override fun getItemId(position: Int): Long { return position.toLong()
    }
    override fun getCount(): Int { return items?.count()!!
    }
    private class ViewHolder(vista: View) {
        var imagen: ImageView = ImageView(vista.context)
        init {
            imagen = vista.imagen
        }
    }
}