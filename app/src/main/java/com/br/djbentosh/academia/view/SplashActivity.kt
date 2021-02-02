package com.br.djbentosh.academia.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.br.djbentosh.academia.R
import kotlinx.android.synthetic.main.tela_inicial_main.*


class SplashActivity : AppCompatActivity() {

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_teste)
        val handle = Handler()
        val nunnable =
        handle.postDelayed(runnable, 3000)
        mostrarLogin()
    }

    private fun mostrarLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

*/

    // abrir com animação SplashActivity
    private val handler = Handler()

    private val runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
}