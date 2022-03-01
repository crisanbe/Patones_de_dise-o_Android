package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

//leer archivos
class ReadCommand: FileCommand {
    override fun execute(context: Context, fileName: String, vararg arguments: String) {
        var fileString = ""
        val inputString = context.openFileInput(fileName)//abra un archivo o directorio
        val stringBuilder = StringBuilder()//guardar cada linea
        val inputStringReader= InputStreamReader(inputString)//poder leer nuestro archivo
        val bufferedReader = BufferedReader(inputStringReader)//permitir leer linea por linea este archivo
        //con bufferedReader.forEachLine que nos haga un salto de linea
        bufferedReader.forEachLine { stringBuilder.append("\n").append(it) }
        fileString = stringBuilder.toString()
        Log.e("ReaderFile", fileString)
    }
}