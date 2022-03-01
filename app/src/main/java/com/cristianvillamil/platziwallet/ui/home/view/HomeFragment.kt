package com.cristianvillamil.platziwallet.ui.home.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_SUCCESS
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observable.AvailableBalanceObservable
import com.cristianvillamil.platziwallet.ui.observable.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter =
        FavoriteTransferAdapter()

    private val availableBalanceObservable = AvailableBalanceObservable()
    private var homePresenter:HomeContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter?.retrieveFavoriteTransfers()
        circularProgress.setProgressWithAnimation(
                70f,
        1000,
        AccelerateDecelerateInterpolator(),
        500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)

        //por medio de este metodo nos va llegar el nuevo valor
        availableBalanceObservable.addObserver(object : Observer{
            @SuppressLint("SetTextI18n")
            override fun notityChange(newValue: Double) {
                amountValueTextView.text = ("$ $newValue")
            }

        })
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter

    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
    }

    //ver los favoritos requerimos el mensage del MessageFactory
    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer)
        val dialogFactory = MessageFactory()
        // aplicamos la funcion scope de alcance let(dejar)
        //y le desimos que dejar si el cotexto (it) puede ser null
        context?.let {
           val errorDialog = dialogFactory.getDialog(it, TYPE_SUCCESS)
            //ver mensage
            errorDialog.show()
        }
    }
}