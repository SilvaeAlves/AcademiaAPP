package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.br.djbentosh.academia.GetCadastro
import com.br.djbentosh.academia.R
import kotlinx.android.synthetic.main.tela_cadastro.*

class CadastrarUsuarioActivity : BaseActivity () {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro)

        btnSalvar.setOnClickListener {
            capturarDados()
        }
    }

    private fun receberUsuarios() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun capturarDados() {

            if (edTelaCadastroEmail.text.toString() == "" &&
                edTelaCadastroNome.text.toString() == "" &&
                edTelaCadastroSenha.text.toString() == "" &&
                edTelaCadastroConfirmacao.text.toString() == ""
            ) {
                Toast.makeText(
                    applicationContext,
                    "Campos vazios ou não prenchidos corretamentes, por favor verifique e tente novamente!",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                    val email = GetCadastro(
                        edTelaCadastroNome.text.toString(),
                        edTelaCadastroEmail.text.toString(),
                        edTelaCadastroSenha.text.toString()
                    )
                receberUsuarios()
            }
    }
}