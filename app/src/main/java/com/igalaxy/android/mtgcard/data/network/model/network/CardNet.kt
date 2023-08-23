package com.igalaxy.android.mtgcard.data.network.model.network

data class CardNet(
    val id: String,

    val image_uris: ImageUris,
    val keywords: List<Any>,
    val lang: String,
    val rarity: String,

    val multiverse_ids: List<Int>,
    val name: String,
    val oracle_id: String,

    val oversized: Boolean,
    val type_line: String,
    val uri: String,
    val variation: Boolean
)