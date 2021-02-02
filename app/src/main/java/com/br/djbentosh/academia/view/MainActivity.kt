package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import com.br.djbentosh.academia.R
import kotlinx.android.synthetic.main.tela_inicial_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial_main)




        btnLoginTelaInicial.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnCadastro.setOnClickListener {
            val intent = Intent(applicationContext, CadastrarUsuarioActivity::class.java)
            startActivity(intent)
        }

    }


}