package com.igalaxy.android.mtgcard.data.network

import com.igalaxy.android.mtgcard.data.network.model.network.CardNet
import com.igalaxy.android.mtgcard.domain.CardRepository
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CardRepositorytImpl : CardRepository {
    //билдим клиент
    val client = OkHttpClient.Builder().build()

    //создаем обьект ретрофит по ссылке с конвертером
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.scryfall.com/")
        .addConverterFactory(GsonConverterFactory.create()).client(client)
        .build()

    //создаем апи
    private val cardApi = retrofit.create(CardAPI::class.java)

    override suspend fun generateImage(): Response<CardNet> {
        // с лайв датой и созданием слушателя
        val imgPath = cardApi.getImage()
        return imgPath
    }


}