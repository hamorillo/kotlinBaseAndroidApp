package com.eirimgroup.eirimbaseapplication.data.repository

import retrofit2.Call
import retrofit2.http.GET

internal interface DataService {

  @GET(value = "5b361731340000030ef8887e")
  fun getAll(): Call<String>
}