package it.macgood.cryptoapp.domain.usecase.getcoinprice

import it.macgood.cryptoapp.common.Resource
import it.macgood.cryptoapp.data.remote.dto.toCoinPrice
import it.macgood.cryptoapp.domain.model.CoinDetail
import it.macgood.cryptoapp.domain.model.CoinPrice
import it.macgood.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinPriceUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<List<CoinPrice>>> = flow {
        try {
            emit(Resource.Loading<List<CoinPrice>>())
            val coins = repository.getCoinsPrices(coinId).map { it.toCoinPrice() }
            emit(Resource.Success<List<CoinPrice>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CoinPrice>>(
                e.localizedMessage ?: "An Unexpected error occurred"
            ))
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinPrice>>("Please, check your Internet connection"))
        }
    }

}