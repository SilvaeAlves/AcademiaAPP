package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.br.djbentosh.academia.*
import kotlinx.android.synthetic.main.tela_cadastro.*
import kotlinx.android.synthetic.main.tela_usuario_list_view.*

class CadastrarUsuarioActivity : BaseActivity () {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro)
        btnSalvar.setOnClickListener {
            capturarDados()
        }
        btnVoltar.setOnClickListener{
            finish()
        }
    }

    private fun receberUsuarios() {
        val intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this,
            "Dados Cadastrados com Sucesso! ",
            Toast.LENGTH_SHORT).show()
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
/*
                    val email = GetCadastro(
                        edTelaCadastroNome.text.toString(),
                        edTelaCadastroEmail.text.toString(),
                        edTelaCadastroSenha.text.toString()
                    )

 */
                getCadastroUsuarios()
            }
    }
    private fun getCadastroUsuarios() = UsuariosRepository.getCadastraUsuario(
        ::onCadasroUsuariosFetched,
        ::onError
    )

    private fun onCadasroUsuariosFetched(usuario: GetCadastroReturn) {
        if (usuario.ok){
            receberUsuarios()
        }else{
            Toast.makeText(this, "Falha ao efetuar Cadastro!", Toast.LENGTH_LONG).show()
        }
    }

    private fun onError(){
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_LONG).show()
    }
}