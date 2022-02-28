package com.cristianvillamil.platziwallet

class UserSingleton {
    var userName = "Cristian"

    companion object{//funcion statica, nos da todos los valores staticos que necesitamos en nuestro proyecto
        private var instance : UserSingleton? = null

       //funcion getInstance()-> es un songleton es una sola instancia
        fun getInstance() : UserSingleton {
            if (instance == null){
                instance = UserSingleton()
            }
        // as garantizamos que va ser siempre un singleton
            return instance as UserSingleton
        }
    }



}