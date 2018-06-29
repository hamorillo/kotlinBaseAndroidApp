package com.eirimgroup.eirimbaseapplication.ui.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eirimgroup.eirimbaseapplication.asApp
import com.eirimgroup.eirimbaseapplication.ui.LifecyclePublisher
import com.eirimgroup.eirimbaseapplication.ui.LifecycleSubscriber
import com.eirimgroup.eirimbaseapplication.ui.lifeCycleLinker
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class BaseActivity : AppCompatActivity(), KodeinAware, LifecyclePublisher by lifeCycleLinker {

  override lateinit var kodein: Kodein

  abstract val layoutId: Int
  abstract val presenter: LifecycleSubscriber
  //    abstract val toolbarView: Toolbar
  abstract val activityModules: Kodein.Module

  override fun onCreate(savedInstanceState: Bundle?) {
    initializeKodein()
    super.onCreate(savedInstanceState)
    setContentView(layoutId)
//        setSupportActionBar(toolbarView)
    register(presenter)
    preparePresenter(intent)
    initialize()
  }

  open fun preparePresenter(intent: Intent?) {}

  override fun onResume() {
    super.onResume()
    update()
  }

  override fun onDestroy() {
    unregister(presenter)
    super.onDestroy()
  }

  open fun initializeKodein() {
    kodein = applicationContext.asApp().kodein
    applicationContext.asApp().addModule(activityModules)
  }
}