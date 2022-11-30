package it.macgood.cryptoapp.domain.usecase.getcoin

import it.macgood.cryptoapp.common.Resource
import it.macgood.cryptoapp.data.remote.dto.toCoinDetail
import it.macgood.cryptoapp.domain.model.CoinDetail
import it.macgood.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Please, check your Internet connection"))
        }
    }
}