package com.igalaxy.android.mtgcard.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igalaxy.android.mtgcard.CardApp
import com.igalaxy.android.mtgcard.data.network.model.network.CardNet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class ChoiceViewModel : ViewModel() {

    private val cardRepository = CardApp.getInstance().cardRepository

    val stateFlow: MutableStateFlow<Response<CardNet>?> = MutableStateFlow(null)

    fun getImage() {
        viewModelScope.launch {
            stateFlow.value = cardRepository.generateImage()
        }
    }


}