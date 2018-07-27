package com.test.kotlinlistview.main

import android.util.Log
import com.test.kotlinlistview.domain.UsecaseController
import com.test.kotlinlistview.model.genre.GetGenres
import com.test.kotlinlistview.model.realmmodels.RealmGenre
import com.test.kotlinlistview.realm.DatabaseManager
import io.realm.RealmResults
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
  view: IMainView,
  usecaseController: UsecaseController,
  dbManager: DatabaseManager
) : IMainPresenter {
  var mainView: IMainView

  var genreUsecaseController: UsecaseController

  private val TAG: String = javaClass.simpleName

  private var mDbManager: DatabaseManager

  init {
    mainView = view
    genreUsecaseController = usecaseController
    mDbManager = dbManager

  }

  override fun getGenreList() {//write something

    var response = genreUsecaseController.getGenreList()

    onResponse(response)

  }

  private fun onResponse(genreList: Observable<GetGenres>) {
    //genreList  -> observable

    var subscription = genreList
        .subscribeOn(Schedulers.io())                     // scheduler
        .observeOn(AndroidSchedulers.mainThread())             // scheduler
        .subscribe(object : Subscriber<GetGenres>() {          //observer
          override fun onNext(t: GetGenres?) {
            // t?.genres=null
            Log.e(TAG, t?.genres?.get(0)?.name)

            t?.genres?.let { mDbManager.saveGenres(it) }
          }

          override fun onCompleted() {
            Log.e(TAG, "OnComplete")
          }

          override fun onError(e: Throwable?) {
            Log.e(TAG, e.toString())
          }

        })

  }

  fun getData(): RealmResults<RealmGenre>? {
    return mDbManager.getGenre()

  }
}

