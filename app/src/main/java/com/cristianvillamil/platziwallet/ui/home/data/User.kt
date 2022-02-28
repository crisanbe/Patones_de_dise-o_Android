package com.cristianvillamil.platziwallet.ui.home.data

//Para acceder al Builder desde HomePresenter le desimos que nuestra clase User private constructor
class User private constructor(private val userName: String, private val password: String) {
    class Builder{
        var userName : String = ""
        var pasword : String? = null
        //Setiamos en nuestra funcion el nuevo usuario
        fun setUserName(newUserName: String) : Builder{
            this.userName = newUserName
            return this
        }

        fun setPassword(newPassword : String): Builder{
            this.pasword = newPassword
            return this
        }

        //este metodo se va encargar de crear la instancia del user
        fun build(): User{
            return User(userName, pasword ?: "")//Operador Elvis , si password es null le pasamos vacio
        }
    }

}