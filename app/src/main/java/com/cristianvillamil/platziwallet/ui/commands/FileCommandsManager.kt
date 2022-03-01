package com.cristianvillamil.platziwallet.ui.commands

import java.lang.RuntimeException

class FileCommandsManager {

    //HashMap
    private  val commands: HashMap<String, FileCommand> = HashMap()

    fun putCommand(commandName: String, fileCommand: FileCommand){
        //commands.put(commandName, fileCommand) = otra accion
        commands[commandName] = fileCommand
    }

    //para poder solicitar un commando, lo obtenemos por su nombre
    fun getCommand(commandName: String): FileCommand{
        if (commands.containsKey(commandName)){//si commands contiene commandName
            //commands.get(commandName)= otra accion
            return commands[commandName]!! //para asegurarnos de que FileCommand no sea nul ponemos !!
        }else{
            throw RuntimeException("command $commandName no esta registrado")
        }

    }
}