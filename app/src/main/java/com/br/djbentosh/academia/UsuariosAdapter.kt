package com.br.djbentosh.academia

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.br.djbentosh.academia.model.Usuarios
import retrofit2.http.GET


class UsuariosAdapter (private val mContext: Context,
                       private var listaUsuarios:List<GetUsuarioResponse>):
    BaseAdapter(){
    private val inflater: LayoutInflater
            = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listView = inflater.inflate(R.layout.tela_usuario, parent, false)
        val item= listaUsuarios[position]
        val txtUsuNome = listView.findViewById<TextView>(R.id.usuario1)
        txtUsuNome.text = item.name
        val txtUsuEmail = listView.findViewById<TextView>(R.id.email1)
        txtUsuEmail.text = item.name
        val txtUsuSenha = listView.findViewById<TextView>(R.id.senha1)
        txtUsuSenha.text = item.name
        val imgUsuList  = listView.findViewById<ImageView>(R.id.imagemUsuario1)
 //       imgUsuList.imageAlpha = item.imagem
        return listView

    }

    override fun getItem(position: Int): GetUsuarioResponse? {
        return listaUsuarios[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listaUsuarios.size
    }

    fun updateusuarios(usuarios: List<GetUsuarioResponse>){
   //     this.listaUsuarios.addAll(usuarios)
        notifyDataSetChanged()

    }
}