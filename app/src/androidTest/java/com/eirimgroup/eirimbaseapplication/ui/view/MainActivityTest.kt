package com.eirimgroup.eirimbaseapplication.ui.view

import com.eirimgroup.eirimbaseapplication.data.repository.GenericRepository
import org.junit.Test
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.mockito.Mock

class MainActivityTest : AcceptanceTest<MainActivity>(MainActivity::class.java) {

    @Mock private lateinit var repository: GenericRepository

    @Test
    fun showsEmptyCaseIfThereAreNoSuperHeroes() {
        val activity = startActivity()

        compareScreenshot(activity)
    }

    override val testDependencies = Kodein.Module("testDependencies", allowSilentOverride = true) {
        bind<GenericRepository>() with instance(repository)
    }
}