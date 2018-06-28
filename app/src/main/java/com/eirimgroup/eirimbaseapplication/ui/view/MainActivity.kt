package com.eirimgroup.eirimbaseapplication.ui.view

import com.eirimgroup.eirimbaseapplication.R
import com.eirimgroup.eirimbaseapplication.ui.presenter.MainActivityPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MainActivity : BaseActivity(), MainActivityPresenter.View{

  override val layoutId: Int = R.layout.activity_main
  override val presenter: MainActivityPresenter by instance()

//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//
//  }

  override val activityModules = Kodein.Module(name="MainActivityModule", allowSilentOverride = true) {
    bind<MainActivityPresenter>() with provider {
      MainActivityPresenter(this@MainActivity)
    }
  }
}
