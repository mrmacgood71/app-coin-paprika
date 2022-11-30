package it.macgood.cryptoapp.presentation.coinlist

import it.macgood.cryptoapp.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)