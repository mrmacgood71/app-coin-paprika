package it.macgood.cryptoapp.domain.usecase.getcoins

import it.macgood.cryptoapp.common.Resource
import it.macgood.cryptoapp.data.remote.dto.toCoin
import it.macgood.cryptoapp.domain.model.Coin
import it.macgood.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map{it.toCoin()}
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected error occurred"))

        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>> ("IOException: Please check your Internet connection"))
        }

    }
}