package ir.vahidmohammadisan.basic_feature.presentation.home

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.vahidmohammadisan.basic_feature.domain.usecase.GetCoinsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.RefreshCoinsUseCase
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsEvent
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsIntent
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsUiState
import ir.vahidmohammadisan.basic_feature.presentation.mapper.toPresentationModel
import ir.vahidmohammadisan.core.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

private const val HTTP_PREFIX = "http"
private const val HTTPS_PREFIX = "https"

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val refreshCoinsUseCase: RefreshCoinsUseCase,
    savedStateHandle: SavedStateHandle,
    coinsInitialState: CoinsUiState,
) : BaseViewModel<CoinsUiState, CoinsUiState.PartialState, CoinsEvent, CoinsIntent>(
    savedStateHandle,
    coinsInitialState,
) {
    init {
        observeRockets()
    }

    override fun mapIntents(intent: CoinsIntent): Flow<CoinsUiState.PartialState> = when (intent) {
        is CoinsIntent.RefreshCoins -> refreshRockets()
        is CoinsIntent.CoinClicked -> coinClicked(intent.id)
    }

    override fun reduceUiState(
        previousState: CoinsUiState,
        partialState: CoinsUiState.PartialState,
    ): CoinsUiState = when (partialState) {
        is CoinsUiState.PartialState.Loading -> previousState.copy(
            isLoading = true,
            isError = false,
        )

        is CoinsUiState.PartialState.Fetched -> previousState.copy(
            isLoading = false,
            coins = partialState.list,
            isError = false,
        )

        is CoinsUiState.PartialState.Error -> previousState.copy(
            isLoading = false,
            isError = true,
        )
    }

    private fun observeRockets() = acceptChanges(
        getCoinsUseCase()
            .map { result ->
                result.fold(
                    onSuccess = { coinList ->
                        CoinsUiState.PartialState.Fetched(coinList.map { it.toPresentationModel() })
                    },
                    onFailure = {
                        CoinsUiState.PartialState.Error(it)
                    },
                )
            }
            .onStart {
                emit(CoinsUiState.PartialState.Loading)
            },
    )

    private fun refreshRockets(): Flow<CoinsUiState.PartialState> = flow<CoinsUiState.PartialState> {
        refreshCoinsUseCase()
            .onFailure {
                emit(CoinsUiState.PartialState.Error(it))
            }
    }.onStart {
        emit(CoinsUiState.PartialState.Loading)
    }

    private fun coinClicked(uri: String): Flow<CoinsUiState.PartialState> {
        if (uri.startsWith(HTTP_PREFIX) || uri.startsWith(HTTPS_PREFIX)) {
            publishEvent(CoinsEvent.OpenWebBrowserWithDetails(uri))
        }

        return emptyFlow()
    }
}