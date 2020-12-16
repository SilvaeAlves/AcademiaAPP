package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.br.djbentosh.academia.GetLogin
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosRepository
import kotlinx.android.synthetic.main.tela_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        btnLogin.setOnClickListener {
            capturaDados()
        }
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun receberUsuarios() {
        val intent = Intent(this, ListarUsuariosActivity::class.java)
        startActivity(intent)
    }

    private fun capturaDados() {

        val email = edTelaLoginEmail.text.toString()
        val senha = edTelaLoginSenha.text.toString()
        var validarlog = true

        if (email == "") {
            validarlog = false
            edTelaLoginEmail.error = "Erro! E-mail não preenchido, por favor verifique!"
        }
        if (senha == "") {
            validarlog = false
            edTelaLoginSenha.error = "Erro! Senha não preenchida, por favor verifique!"
        }
        if (validarlog) {
            getLoginUsuarios()
        }


    }

    private fun getLoginUsuarios() = UsuariosRepository.getLoginAutentica(
        ::onLoginFetched,
        ::onError
    )

    private fun onLoginFetched(usuario: GetLogin) {

        if (edTelaLoginEmail.text.toString() == usuario.user && edTelaLoginSenha.text.toString() == usuario.pass) {
            receberUsuarios()
        } else {
            Toast.makeText(this, "Falha ao efetuar Login!", Toast.LENGTH_LONG).show()
        }
    }

    private fun onError() {
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_LONG)
            .show()
    }
}




