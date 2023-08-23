package com.igalaxy.android.mtgcard.domain

import com.igalaxy.android.mtgcard.data.network.model.network.CardNet
import retrofit2.Response


interface CardRepository {

suspend fun generateImage() : Response<CardNet>

}