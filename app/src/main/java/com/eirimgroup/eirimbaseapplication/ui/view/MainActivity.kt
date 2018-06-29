package com.eirimgroup.eirimbaseapplication.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.eirimgroup.eirimbaseapplication.R
import com.eirimgroup.eirimbaseapplication.ui.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MainActivity : BaseActivity(), MainActivityPresenter.View{

  companion object {

    fun open(activity: Activity){
      val intent = Intent(activity, MainActivity::class.java)
      activity.startActivity(intent)
    }
  }

  override val layoutId: Int = R.layout.activity_main
  override val presenter: MainActivityPresenter by instance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    hello_eirim_tv.setText("Eirim")
  }

  override val activityModules = Kodein.Module(name="MainActivityModule", allowSilentOverride = true) {
    bind<MainActivityPresenter>() with provider {
      MainActivityPresenter(this@MainActivity)
    }
  }
}
