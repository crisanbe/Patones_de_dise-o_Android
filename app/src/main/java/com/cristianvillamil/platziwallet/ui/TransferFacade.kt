package com.cristianvillamil.platziwallet.ui

//RESPONSABLE DE LOS SUBSISTEMAS
class TransferFacade {
    //tiene las instancias de dichos sistemas (Security y Analitics
    //dos formas de instanciar
    val analyticsManager: AnalyticsManager = AnalyticsManager()//dandole el tipo AnalyticsManager  a la variable
    val securityManager = SecurityManager()//aqui ya sabe cual es el tipo
    val transferManager = TransferManager()

    fun transfer(){
        val token = securityManager.getToken()
        //Encapsulamos dos sistemas
        analyticsManager.registerTransfer(token)
        transferManager.transfer(token)
    }
}