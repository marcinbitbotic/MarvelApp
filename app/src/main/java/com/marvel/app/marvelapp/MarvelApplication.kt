package com.marvel.app.marvelapp

import android.app.Application
import com.marvel.app.marvelapp.dagger.component.ApplicationComponent
import com.marvel.app.marvelapp.dagger.component.DaggerApplicationComponent
import com.marvel.app.marvelapp.dagger.module.ApplicationModule

/**
 * Created by Marcin Pogorzelski on 27/09/2017.
 */

class MarvelApplication : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                //.networkModule(NetworkModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }

}