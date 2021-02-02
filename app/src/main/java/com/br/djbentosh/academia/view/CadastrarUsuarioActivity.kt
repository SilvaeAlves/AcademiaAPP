package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.br.djbentosh.academia.GetCadastroReturn
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosRepository
import kotlinx.android.synthetic.main.tela_cadastro.*

class CadastrarUsuarioActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro)
        btnSalvar.setOnClickListener {
            capturarDados()
        }
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun receberUsuarios() {
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(
            this,
            "Dados Cadastrados com Sucesso! ",
            Toast.LENGTH_SHORT
        ).show()
        startActivity(intent)
    }

    private fun capturarDados() {

        val email = edTelaCadastroEmail.text.toString()
        val nome = edTelaCadastroNome.text.toString()
        val senha = edTelaCadastroSenha.text.toString()
        val confimsenha = edTelaCadastroConfirmacao.text.toString()
        var validarcad = true

        if (email == "") {
            validarcad = false
            edTelaCadastroEmail.error = "Campo de  E-mail não preenchido, por favor preencher!"
        }
        if (nome == "") {
            validarcad = false
            edTelaCadastroNome.error = "Caompo do Nome não preenchido, por favor preencher!"
        }
        if (senha == "") {
            validarcad = false
            edTelaCadastroSenha.error = "Campo da Senha não preenchida, por favor preencher!"
        }
        if (confimsenha == "") {
            validarcad = false
            edTelaCadastroConfirmacao.error = "Campo confirmação da senha não prenchido ou confere, por favor verifique!"
        }
        if (validarcad) {
            getCadastroUsuarios()
        }


    }

    private fun getCadastroUsuarios() = UsuariosRepository.getCadastraUsuario(
        ::onCadasroUsuariosFetched,
        ::onError
    )

    private fun onCadasroUsuariosFetched(usuario: GetCadastroReturn) {
        if (usuario.ok) {
            receberUsuarios()
        } else {
            Toast.makeText(this, "Falha ao efetuar Cadastro!", Toast.LENGTH_LONG).show()
        }
    }


    private fun onError() {
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_LONG)
            .show()
    }
}

