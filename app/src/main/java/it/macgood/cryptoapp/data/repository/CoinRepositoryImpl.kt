package it.macgood.cryptoapp.data.repository

import android.util.Log
import it.macgood.cryptoapp.data.remote.CoinPaprikaApi
import it.macgood.cryptoapp.data.remote.dto.CoinDetailDto
import it.macgood.cryptoapp.data.remote.dto.CoinDto
import it.macgood.cryptoapp.data.remote.dto.CoinPriceDto
import it.macgood.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getCoinPrice(coinId: String): CoinPriceDto {
        return api.getCoinPrice(coinId)
    }

    override suspend fun getCoinsPrices(coinId: String): List<CoinPriceDto> {
        var prices: MutableList<CoinPriceDto> = mutableListOf()

        val coins = getCoins()

        for (i in 1..5) {
            prices.add(getCoinPrice(coins.get(i).id))
            Log.d("Price", prices.get(i).open.toString())
        }

        return prices
    }
}