package com.marvel.app.marvelapp.dagger.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Marcin Pogorzelski on 27/09/2017.
 */

@Module
//class ApplicationModule(val application: Context) {
class ApplicationModule{

    val application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideApplication() : Application {
        return application
    }

}

