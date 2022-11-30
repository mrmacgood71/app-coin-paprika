package it.macgood.cryptoapp.presentation.coinlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.cryptoapp.common.Constants
import it.macgood.cryptoapp.common.Resource
import it.macgood.cryptoapp.domain.model.CoinPrice
import it.macgood.cryptoapp.domain.usecase.getcoin.GetCoinUseCase
import it.macgood.cryptoapp.domain.usecase.getcoinprice.GetCoinPriceUseCase
import it.macgood.cryptoapp.presentation.coindetail.CoinDetailState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinPriceViewModel @Inject constructor(
    private val getCoinPriceUseCase: GetCoinPriceUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinPriceState())
    val state: State<CoinPriceState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId -> getCoin(coinId) }
    }

    private fun getCoin(coinId: String) {
        getCoinPriceUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {

                    _state.value = CoinPriceState(coins = result.data ?:
                        emptyList()
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinPriceState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinPriceState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}