package com.br.djbentosh.academia.view

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // deixar toolbar escondida
        supportActionBar!!.hide()

        // barra de atualização de progressão entre as telas (activitys)
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Atualizando......")
        progressDialog.setCancelable(false)
        progressDialog.show()

        Handler().postDelayed({progressDialog.dismiss()}, 2000)

        // deixar visualização da tela em full screen

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}