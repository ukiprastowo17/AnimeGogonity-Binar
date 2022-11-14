package com.catnip.animegogonity.data.network.api.service

import com.catnip.animegogonity.data.network.api.model.Anime
import com.catnip.animegogonity.data.network.api.model.AnimeDetail
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit
import com.chuckerteam.chucker.api.ChuckerInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface GogoAnimeApiService {
    @GET("anime-movies")
    suspend fun getAnimeList(@Query("page") page : Int = 1) : List<Anime>

    @GET("top-airing")
    suspend fun getTopAiringAnimeList(@Query("page") page : Int = 1) : List<Anime>

    @GET("recent-release")
    suspend fun getRecentReleaseAnimeList(@Query("page") page : Int = 1) : List<Anime>

    @GET("anime-details/{animeId}")
    suspend fun getAnimeDetail(@Path("animeId") animeId : String) : AnimeDetail

    companion object{
        @JvmStatic
        operator fun invoke(chuckerInterceptor: ChuckerInterceptor): GogoAnimeApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(chuckerInterceptor)
                .connectTimeout(120,TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()


            val retrofit =  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(GogoAnimeApiService::class.java)
        }
    }

}