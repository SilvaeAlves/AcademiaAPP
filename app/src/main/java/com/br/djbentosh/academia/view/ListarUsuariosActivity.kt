package com.br.djbentosh.academia.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.br.djbentosh.academia.GetUsuarioResponse
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosAdapter
import com.br.djbentosh.academia.UsuariosRepository.getListaUsuarios
import kotlinx.android.synthetic.main.tela_usuario_list_view.*

class ListarUsuariosActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_usuario_list_view)
        getListaUsuarios()

        val button: Button = findViewById<Button>(R.id.btn_adic_usuario)
        button.setOnClickListener {
            abrirNovoUsuario()
        }

/*
        btn_adic_usuario.setOnClickListener {
            val intent = Intent(applicationContext, CadastrarUsuarioActivity::class.java)
            startActivity(intent)
        }

 */
    }

    private fun abrirNovoUsuario() {
        val windowUserAdd = WindowUserAdd()
        windowUserAdd.show(supportFragmentManager, "Teste box Usuário")
    }


    private fun getListaUsuarios() = getListaUsuarios(
        ::onListUsuariosFetched,
        ::onError
    )

    private fun onListUsuariosFetched(usuario: List<GetUsuarioResponse>) {
        val adapter = UsuariosAdapter(this, usuario)

        lista.adapter = adapter
    }

    private fun onError() {
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_SHORT)
            .show()
    }


}