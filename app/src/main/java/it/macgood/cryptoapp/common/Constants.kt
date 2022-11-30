package it.macgood.cryptoapp.common

import it.macgood.cryptoapp.domain.model.CoinPrice

object Constants {
    const val BASE_URL = "https://api.coinpaprika.com/"

    const val PARAM_COIN_ID = "coinId"
    val TODO_COIN_PRICE = CoinPrice("0", 0.0, 0, 0)
}