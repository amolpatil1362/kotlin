package com.test.kotlinlistview.domain

import android.util.Log
import com.test.kotlinlistview.model.genre.GetGenres
import com.test.kotlinlistview.network.GetGenereAPI
import com.test.kotlinlistview.network.INetworkAPI
import com.test.kotlinlistview.network.NetworkCallManager
import com.test.kotlinlistview.network.NetworkRequest
import rx.Observable
import rx.Subscription
import javax.inject.Inject

class UsecaseController @Inject constructor() : IUsecase {

  override fun getGenreList(): Observable<GetGenres> {//write something

    val networkRequest: NetworkRequest = GetGenereAPI().buildApiParam()
    val networkManager: INetworkAPI = NetworkCallManager().createAPIAdapter()
    Log.e("API URL is ",networkRequest.getUrl())
    var response: Observable<GetGenres> = networkManager.getGenreData(networkRequest.getUrl()!!)

    return response
   // onResponse(response)


  }

  private var subscription: Subscription? = null

  /*override fun onResponse(response: Observable<GetGenres>) {//write something
   subscription =  response
        .subscribeOn(Schedulers.io())
        .subscribe(object : Subscriber<GetGenres>() {
      override fun onCompleted() {

      }

      override fun onError(e: Throwable) {
        e.printStackTrace()
      }

      override fun onNext(getGenreResponse: GetGenres) {

        Log.e("Response is ",getGenreResponse.genres!!.get(0).name)

      }
    })
  }*/

}