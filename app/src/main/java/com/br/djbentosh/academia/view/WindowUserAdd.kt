package com.br.djbentosh.academia.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class WindowUserAdd:AppCompatDialogFragment(){

    fun WindowUserAdd.onCreateDialog(savedInstanceState:Bundle):Dialog{
        val builder = AlertDialog.Builder(activity)
        val positiveButton =
            builder.setTitle("Novo Usuário")
                .setMessage("Email")
                .setPositiveButton("ok", DialogInterface.OnClickListener())
                .setNegativeButton("Cancel", DialogInterface.OnClickListener())

        @Override
        fun onClick (dialogInterface: DialogInterface) = Unit
        onClick(dialogInterface = onCreateDialog(Bundle.EMPTY))


        return builder.create()
    }


}

