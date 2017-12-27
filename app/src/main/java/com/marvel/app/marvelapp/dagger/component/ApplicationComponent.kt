package com.marvel.app.marvelapp.dagger.component


import com.marvel.app.marvelapp.MainActivity
import com.marvel.app.marvelapp.dagger.module.ApplicationModule
import com.marvel.app.marvelapp.dagger.module.NetworkModule
import com.marvel.app.marvelapp.fragment.ListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Marcin Pogorzelski on 27/09/2017.
 */

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class)
)

interface ApplicationComponent {
    //fun inject(mainActivity: MainActivity)
    fun inject(listFragment: ListFragment)
    // fun plus(pokemonListModule: PokemonListModule): PokemonListComponent

}

