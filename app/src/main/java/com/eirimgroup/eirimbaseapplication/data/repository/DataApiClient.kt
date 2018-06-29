package com.eirimgroup.eirimbaseapplication.data.repository

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class DataApiClient @JvmOverloads constructor(baseEndpoint: String = "http://www.mocky.io/v2/") {

  private val dataService: DataService

  init {
    val retrofit = Retrofit.Builder()
            .baseUrl(baseEndpoint)
//            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

    this.dataService = retrofit.create(DataService::class.java)
  }

  fun getAll(): Response<String> =
     dataService.getAll().execute()
}