package com.marvel.app.marvelapp.retrofit

import com.marvel.app.marvelapp.model.ResponseModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


/**
 * Created by Marcin Pogorzelski on 21/09/2017.
 */
interface MarvelAPI {

    // BaseURL
    // https://api.myjson.com/bins/bvyob

    @GET("/bins/bvyob")
    fun getHeros(): Call<ResponseModel>;


    /**
     * Companion object to create the MarvelAPI
     */
    companion object Factory {

        fun create(): MarvelAPI {

            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
            okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)

            okHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("https://api.myjson.com")
                    .client(okHttpClientBuilder.build())
                    .build()

            return retrofit.create(MarvelAPI::class.java);
        }
    }
}