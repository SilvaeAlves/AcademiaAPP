package com.br.djbentosh.academia.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import com.br.djbentosh.academia.GetUsuario
import com.br.djbentosh.academia.GetUsuarioResponse
import com.br.djbentosh.academia.R
import com.br.djbentosh.academia.UsuariosAdapter
import com.br.djbentosh.academia.UsuariosRepository.getListaUsuarios
import kotlinx.android.synthetic.main.tela_add_usu_layout_dialog.view.*
import kotlinx.android.synthetic.main.tela_remove_alt_usu.*
import kotlinx.android.synthetic.main.tela_usuario_list_view.*

class ListarUsuariosActivity : BaseActivity() {

    private lateinit var mAlertDialog:AlertDialog
    private lateinit var mBuilder:AlertDialog.Builder
    private lateinit var aAlertDialog: AlertDialog
    private lateinit var aBuilder:AlertDialog.Builder
    private lateinit var novoUsuario:UsuariosAdapter
    private lateinit var usuarios:MutableList<GetUsuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_usuario_list_view)
        getListaUsuarios()
        iniciarDialog()
        alterarDialog()


        this.btn_alterar.setOnClickListener {
            mAlertDialog = mBuilder.show()
        }

        this.btn_adic_usuario.setOnClickListener {
            mAlertDialog = mBuilder.show()
        }
    }

    private fun alterarDialog(){
        val aDialogView = LayoutInflater.from(this).inflate(R.layout.tela_add_usu_layout_dialog, null)
        aBuilder = AlertDialog.Builder(this)
            .setView(aDialogView)
            .setTitle("Alterar Novo Usuário")
        aDialogView.btn_adic_usu_alertdialog.setOnClickListener(){

            val id_name = aDialogView.edit_text_nome_usuario.text.toString()
            val title = aDialogView.edit_text_title_usuario.text.toString()
            val last_name = aDialogView.edit_text_sobrenome_usuario.text.toString()
            val location =aDialogView.edit_text_location_usuario.text.toString()
            var validar_add = true

            if (id_name == ""){
                validar_add = false
                aDialogView.edit_text_nome_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (title == ""){
                validar_add = false
                aDialogView.edit_text_title_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (last_name == ""){
                validar_add = false
                aDialogView.edit_text_sobrenome_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (location == ""){
                validar_add = false
                aDialogView.edit_text_location_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (validar_add){
                adicionaUsuario(
                    GetUsuario(id_name, title, last_name, location, "https://png.pngtree.com/png-vector/20191110/ourlarge/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396.jpg")
                )
                Toast.makeText(
                    this,
                    "Dados Cadastrados com Sucesso! ",
                    Toast.LENGTH_SHORT
                ).show()
                aAlertDialog.dismiss()
            }

        }
    }


    private fun iniciarDialog () {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.tela_add_usu_layout_dialog, null)
         mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Cadastrar Novo Usuário")

        mDialogView.btn_adic_usu_alertdialog.setOnClickListener() {


            val id_name = mDialogView.edit_text_nome_usuario.text.toString()
            val title = mDialogView.edit_text_title_usuario.text.toString()
            val last_name = mDialogView.edit_text_sobrenome_usuario.text.toString()
            val location = mDialogView.edit_text_location_usuario.text.toString()
            var validar_add = true

            if (id_name == ""){
                validar_add = false
                mDialogView.edit_text_nome_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (title == ""){
                validar_add = false
                mDialogView.edit_text_title_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (last_name == ""){
                validar_add = false
                mDialogView.edit_text_sobrenome_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (location == ""){
                validar_add = false
                mDialogView.edit_text_location_usuario.error = "Este campo não foi preenchido, por favor preencher!"
            }
            if (validar_add){
                adicionaUsuario(
                    GetUsuario(id_name, title, last_name, location, "https://png.pngtree.com/png-vector/20191110/ourlarge/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396.jpg")
                )
                Toast.makeText(
                    this,
                    "Dados Cadastrados com Sucesso! ",
                    Toast.LENGTH_SHORT
                ).show()
                mAlertDialog.dismiss()
            }
        }
    }

    private fun getListaUsuarios() = getListaUsuarios(
        ::onListaFetched,
        ::onError
    )

    private fun onListaFetched(usuariosReponse: List<GetUsuarioResponse>) {
        usuarios = mutableListOf()
        usuariosReponse.forEach {
            usuarios.add(
                GetUsuario(
                    it.id,
                    it.title,
                    it.name,
                    it.location,
                    it.image
                )
            )
        }
        novoUsuario = UsuariosAdapter (this, usuarios)
        lista.adapter = novoUsuario

        lista.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            val usuarioSelecionado = usuarios[position]
            showDialogBtnRemovAlt(usuarioSelecionado)
            }
        })
    }

    private fun onError() {
        Toast.makeText(this, "Por favor verifique sua conexão de internet", Toast.LENGTH_SHORT)
            .show()
    }

    private fun adicionaUsuario(adicionaUsuario:GetUsuario){
        usuarios.add(adicionaUsuario)
        novoUsuario.notifyDataSetChanged()
    }

    private fun showDialogBtnRemovAlt(usuario: GetUsuario) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.tela_remove_alt_usu)
        val removeBtn = dialog.findViewById(R.id.btn_remover) as Button
        val alteraBtn = dialog.findViewById(R.id.btn_alterar) as Button
        removeBtn.setOnClickListener {
            novoUsuario.removeUsuario(usuario)
            novoUsuario.notifyDataSetChanged()
        }
        alteraBtn.setOnClickListener {
            novoUsuario.alteraUsuario(usuario)
            novoUsuario.notifyDataSetChanged()
        }
        dialog.show()

    }
}


