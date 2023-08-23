package com.igalaxy.android.mtgcard

import android.app.Application
import com.igalaxy.android.mtgcard.data.network.CardRepositorytImpl

class CardApp : Application() {
    val cardRepository = CardRepositorytImpl()

    companion object {
        private var INSTANCE: CardApp? = null
        fun getInstance(): CardApp {
            if (INSTANCE == null) {
                INSTANCE = CardApp()
            }
            return INSTANCE as CardApp
        }
    }

}