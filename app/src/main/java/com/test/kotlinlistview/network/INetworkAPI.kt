package com.test.kotlinlistview.network

import com.test.kotlinlistview.model.genre.GetGenres
import retrofit2.http.GET
import retrofit2.http.Url
import rx.Observable

interface INetworkAPI {

  @GET
  abstract fun getGenreData(@Url str: String): Observable<GetGenres>


}