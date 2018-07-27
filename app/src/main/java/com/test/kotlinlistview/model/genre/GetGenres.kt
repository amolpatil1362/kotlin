package com.test.kotlinlistview.model.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetGenres {

  @SerializedName("genres")
  @Expose
  var genres: List<Genre>? = null

}
