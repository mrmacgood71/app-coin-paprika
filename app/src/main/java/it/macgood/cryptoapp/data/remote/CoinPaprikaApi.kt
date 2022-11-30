package it.macgood.cryptoapp.data.remote

import it.macgood.cryptoapp.data.remote.dto.CoinDetailDto
import it.macgood.cryptoapp.data.remote.dto.CoinDto
import it.macgood.cryptoapp.data.remote.dto.CoinPriceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("/v1/coins/{coinId}/ohlcv/today")
    suspend fun getCoinPrice(@Path("coinId") coinId: String): CoinPriceDto

}