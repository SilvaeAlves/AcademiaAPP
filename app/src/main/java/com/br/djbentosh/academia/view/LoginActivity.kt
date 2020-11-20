package com.br.djbentosh.academia.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import com.br.djbentosh.academia.R
import kotlinx.android.synthetic.main.tela_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        btnLogin.setOnClickListener {
            capturaDados()
            }
        }

    private fun receberUsuarios (){
        val intent = Intent(this, ListarUsuariosActivity::class.java)
        startActivity(intent)
    }

    private fun capturaDados() {

        if (edTelaLoginEmail.text.toString() == "" &&
            edTelaLoginSenha.text.toString() == ""
        ) {
            Toast.makeText(
                applicationContext,
                "Campos vazios ou não prenchidos corretamentes, por favor verifique e tente novamente!",
                Toast.LENGTH_LONG
            ).show()
        } else {
/*
            val email = GetLogin(
                edTelaLoginEmail.text.toString(),
                edTelaLoginSenha.text.toString()
            )
*/
            receberUsuarios()
        }
    }
}


