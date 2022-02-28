package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view:HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                //Gracias a nuestra funcion stica  companion object podemos llamarla nuestro getInstance()
                //Aunque en nuestra clase UserSingleton las funciones sean publicas no las va traer y por ende utilizamos  (companion object)
                //Para traer nuestros valores (userName) hay que tener en cuenta cuales son los valores que hacen parte de nuestra funcion statica y de
                //y nuestra clase UserSingleton
                UserSingleton.getInstance().userName = "hola"
                val user = User.Builder()
                    .setUserName("hola")
                    .setPassword("hfdfjdnfkjdf")
                    .build()
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }
}