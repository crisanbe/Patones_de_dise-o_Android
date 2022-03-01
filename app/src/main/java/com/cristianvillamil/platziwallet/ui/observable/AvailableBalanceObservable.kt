package com.cristianvillamil.platziwallet.ui.observable

class AvailableBalanceObservable :  Observable{
    private val amountObserverList: ArrayList<Observer> = arrayListOf()
    private var amount: Double = 0.0

    //con esta funcion vamos a cambiar el saldo disponible
    fun changeAmount(newValue: Double){
        amount = newValue
        notifyObserver(amount)
    }

    override fun addObserver(observer: Observer) {
        amountObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        amountObserverList.remove(observer)
    }

    override fun notifyObserver(newValue: Double) {
        amountObserverList.forEach {
            //con el foreach funcion Scope recorremos las nuevas notificaciones de las suscripciones agregadas
            it.notityChange(newValue)
        }
    }
}