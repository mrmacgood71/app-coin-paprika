package it.macgood.cryptoapp.presentation.coinlist

import it.macgood.cryptoapp.domain.model.CoinPrice

data class CoinPriceState(
    val isLoading: Boolean = false,
    val coins: List<CoinPrice> = emptyList(),
    val error: String = ""
)
