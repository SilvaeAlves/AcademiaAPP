package com.br.djbentosh.academia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class UsuariosAdapter(
    private val mContext: Context,
    private var listaUsuarios: MutableList<GetUsuario>
) :
    BaseAdapter() {
    private val inflater: LayoutInflater =
        mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listView = inflater.inflate(R.layout.tela_usuario, parent, false)

        val item = listaUsuarios[position]

        val txtUsuId = listView.findViewById<TextView>(R.id.usuarioId)
        txtUsuId.text = item.id

        val txtUsuTitle = listView.findViewById<TextView>(R.id.title1)
        txtUsuTitle.text = item.title

        val txtUsuName = listView.findViewById<TextView>(R.id.email1)
        txtUsuName.text = item.name

        val txtUsuLocation = listView.findViewById<TextView>(R.id.senha1)
        txtUsuLocation.text = item.location

        val imgUsuList = listView.findViewById<ImageView>(R.id.imagemUsuario1)
        Picasso.get().load(item.image).into(imgUsuList)

        return listView
    }

    override fun getItem(position: Int): GetUsuario? {
        return listaUsuarios[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listaUsuarios.size
    }

    fun removeUsuario(removeUsuario: GetUsuario){
        listaUsuarios.remove(removeUsuario)
    }

    fun alteraUsuario (alteraUsuario: GetUsuario){
        listaUsuarios.add(alteraUsuario)
    }
}