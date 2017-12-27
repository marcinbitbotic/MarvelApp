package com.marvel.app.marvelapp.retrofit

import android.content.Context
import com.marvel.app.marvelapp.model.ResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Marcin Pogorzelski on 28/09/2017.
 */
class NetworkService {

    val api : MarvelAPI
    val context : Context

    @Inject
    constructor( marvelAPI: MarvelAPI, context: Context) {
        this.api = marvelAPI
        this.context = context
    }

    fun loadHerosList(): Call<ResponseModel> {
        return  api.getHeros()
    }
}