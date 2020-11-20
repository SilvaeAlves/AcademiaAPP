package com.br.djbentosh.academia.view

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.br.djbentosh.academia.GetUsuarioResponse
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosAdapter
import com.br.djbentosh.academia.UsuariosRepository.getListaUsuarios
import kotlinx.android.synthetic.main.tela_usuario_list_view.*

class ListarUsuariosActivity: BaseActivity () {

    private lateinit var listView: ListView
    private lateinit var listaUsuariosAdapter: UsuariosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_usuario_list_view)

        getListaUsuarios()
    }

    private fun getListaUsuarios() = getListaUsuarios(
        ::onListUsuariosFetched,
        ::onError
    )

    private fun onListUsuariosFetched(usuario: List<GetUsuarioResponse>) {
  //      listaUsuariosAdapter.updateusuarios(usuario)
        val adapter = UsuariosAdapter (this, usuario)

        lista.adapter = adapter
    }

    private fun onError(){
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_SHORT).show()
    }


}