package it.macgood.cryptoapp.presentation.coindetail

import it.macgood.cryptoapp.domain.model.Coin
import it.macgood.cryptoapp.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)