package com.igalaxy.android.mtgcard.data.network

import com.igalaxy.android.mtgcard.data.network.model.network.CardNet
import retrofit2.Response
import retrofit2.http.GET


interface CardAPI {
    /*@GET("https://api.scryfall.com/cards/multiverse/{id}")
    suspend fun getImage(@Path("id")id: Int): Response<CardNet>*/
    @GET("https://api.scryfall.com/cards/random")
    suspend fun getImage(): Response<CardNet>
}