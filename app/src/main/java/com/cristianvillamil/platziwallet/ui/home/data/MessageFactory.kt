package com.cristianvillamil.platziwallet.ui.home.data

import android.app.AlertDialog
import android.content.Context

class MessageFactory {
    //variables staticas
    companion object {
        val TYPE_ERROR = "typeError"
        val TYPE_SUCCESS = "typeSucces"
        val TYPE_INFO = "typeInfo"
    }

    fun getDialog(context: Context, type: String): AlertDialog.Builder {
        when (type) {
            TYPE_ERROR -> {
                return AlertDialog.Builder(context)
                    .setMessage("Hay un error al momento de traer contenido")
            }
            TYPE_SUCCESS -> {
                return AlertDialog.Builder(context)
                    .setMessage("El contenido fue cargado correctamente!")
            }
            TYPE_INFO -> {
                return AlertDialog.Builder(context)
                    .setMessage("Info")
            }
        }
        return AlertDialog.Builder(context)
            .setMessage("Necesitas añadir un nuevo tipo")
    }
}