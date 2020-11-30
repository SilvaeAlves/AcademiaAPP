package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.br.djbentosh.academia.GetLogin
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosRepository
import kotlinx.android.synthetic.main.tela_login.*
import kotlinx.android.synthetic.main.tela_usuario.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        btnLogin.setOnClickListener {
            capturaDados()
        }
        btnVoltar.setOnClickListener{
            finish()
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
            getLoginUsuarios()
        }
    }

    private fun getLoginUsuarios() = UsuariosRepository.getLoginAutentica(
        ::onLoginFetched,
        ::onError
    )

    private fun onLoginFetched(usuario: GetLogin) {
        if (edTelaLoginEmail == email1 && edTelaLoginSenha == senha1){
            receberUsuarios()
        }else{
            Toast.makeText(this, "Falha ao efetuar Login!", Toast.LENGTH_LONG).show()
        }
    }

    private fun onError(){
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_LONG).show()
    }
}


