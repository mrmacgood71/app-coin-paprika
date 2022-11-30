package it.macgood.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName

class Links (
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    @SerializedName("source_code")
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
