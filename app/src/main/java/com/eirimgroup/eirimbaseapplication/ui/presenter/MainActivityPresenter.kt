package com.eirimgroup.eirimbaseapplication.ui.presenter

import android.util.Log
import co.metalab.asyncawait.async
import com.eirimgroup.eirimbaseapplication.domain.usecase.GetAll
import com.eirimgroup.eirimbaseapplication.ui.LifecycleSubscriber
import org.funktionale.either.Either

class MainActivityPresenter(
        val view: View,
        val getAll: GetAll):
        LifecycleSubscriber {

  override fun initialize() {
    super.initialize()
    async({
      val result = await{getAll.invoke()}
      when(result){
        is Either.Left -> Log.d("re", "error")
        is Either.Right -> Log.d("re", "OK")
      }
    })
  }

  override fun update() {
    super.update()
  }

  interface View {

  }
}