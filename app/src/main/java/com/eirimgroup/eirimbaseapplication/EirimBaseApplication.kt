package com.eirimgroup.eirimbaseapplication

import android.app.Application
import android.content.Context
import com.eirimgroup.eirimbaseapplication.data.repository.GenericRepository
import org.kodein.di.KodeinAware
import org.kodein.di.Kodein.Module
import org.kodein.di.conf.ConfigurableKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class EirimBaseApplication: Application(), KodeinAware{
  override val kodein = ConfigurableKodein(mutable = true)
  var overrideModule: Module? = null

  override fun onCreate() {
    super.onCreate()
    resetInjection()
  }

  fun addModule(activityModules: Module) {
    kodein.addImport(activityModules, true)
    if (overrideModule != null) {
      kodein.addImport(overrideModule!!, true)
    }
  }

  fun resetInjection() {
    kodein.clear()
    kodein.addImport(appDependencies(), true)
  }

  private fun appDependencies(): Module {
    return Module(name="genericRepository", allowSilentOverride = true) {
      bind<GenericRepository>() with singleton {
        GenericRepository()
      }
    }
  }
}

fun Context.asApp() = this.applicationContext as EirimBaseApplication;