package com.cristianvillamil.platziwallet.ui

class TransferProxy {
    val MAX_TRANSFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100

    //regla de negocio
    fun checkTransfer(amount: Double): String{
        return when{
            amount > MAX_TRANSFER_AMOUNT -> {
                "la transacción excede el monto"
            }
            amount > MIN_TRANSFER_AMOUNT -> {
                "la transacción debe ser mayor al $MIN_TRANSFER_AMOUNT"
            }
            else -> {
                "la transferencia se realizo correctamente"
            }
        }
    }

    //funcion de realiza la tranferencia luego de que se realizo el estudio prebio de la regla de negocio
    private  fun doTransfer(amount: Double){

    }
}