package com.test.kotlinlistview.domain

import com.test.kotlinlistview.model.genre.GetGenres
import rx.Observable

interface IUsecase {
  fun getGenreList(): Observable<GetGenres>
  //fun onResponse(response: Observable<GetGenres>)

}