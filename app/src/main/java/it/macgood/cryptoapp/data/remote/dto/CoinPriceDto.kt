package it.macgood.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import it.macgood.cryptoapp.domain.model.CoinPrice

data class CoinPriceDto(
    val id: String,
    @SerializedName("time_open")
    val timeOpen: String,
    @SerializedName("time_close")
    val timeClose: String,
    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,
    val volume: Long,
    @SerializedName("market_cap")
    val marketCap: Long
)

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        id = id,
        open = open,
        volume = volume,
        marketCap = marketCap
    )
}
