package it.macgood.cryptoapp.domain.repository

import it.macgood.cryptoapp.data.remote.dto.CoinDetailDto
import it.macgood.cryptoapp.data.remote.dto.CoinDto
import it.macgood.cryptoapp.data.remote.dto.CoinPriceDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

    suspend fun getCoinPrice(coinId: String): CoinPriceDto

    suspend fun getCoinsPrices(coinId: String): List<CoinPriceDto>

}