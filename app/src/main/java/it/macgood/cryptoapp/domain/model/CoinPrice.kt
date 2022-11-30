package it.macgood.cryptoapp.domain.model

data class CoinPrice(
    val id: String,
    val open: Double,
    val volume: Long,
    val marketCap: Long
)
