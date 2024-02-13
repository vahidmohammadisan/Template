package ir.vahidmohammadisan.basic_feature.presentation

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.vahidmohammadisan.basic_feature.domain.usecase.GetRocketsUseCase
import ir.vahidmohammadisan.basic_feature.domain.usecase.RefreshRocketsUseCase
import ir.vahidmohammadisan.basic_feature.presentation.RocketsEvent.OpenWebBrowserWithDetails
import ir.vahidmohammadisan.basic_feature.presentation.RocketsIntent.RefreshRockets
import ir.vahidmohammadisan.basic_feature.presentation.RocketsIntent.RocketClicked
import ir.vahidmohammadisan.basic_feature.presentation.RocketsUiState.PartialState
import ir.vahidmohammadisan.basic_feature.presentation.RocketsUiState.PartialState.Error
import ir.vahidmohammadisan.basic_feature.presentation.RocketsUiState.PartialState.Fetched
import ir.vahidmohammadisan.basic_feature.presentation.RocketsUiState.PartialState.Loading
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
class RocketsViewModel @Inject constructor(
    private val getRocketsUseCase: GetRocketsUseCase,
    private val refreshRocketsUseCase: RefreshRocketsUseCase,
    savedStateHandle: SavedStateHandle,
    rocketsInitialState: RocketsUiState,
) : BaseViewModel<RocketsUiState, PartialState, RocketsEvent, RocketsIntent>(
    savedStateHandle,
    rocketsInitialState,
) {
    init {
        observeRockets()
    }

    override fun mapIntents(intent: RocketsIntent): Flow<PartialState> = when (intent) {
        is RefreshRockets -> refreshRockets()
        is RocketClicked -> rocketClicked(intent.uri)
    }

    override fun reduceUiState(
        previousState: RocketsUiState,
        partialState: PartialState,
    ): RocketsUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false,
        )

        is Fetched -> previousState.copy(
            isLoading = false,
            rockets = partialState.list,
            isError = false,
        )

        is Error -> previousState.copy(
            isLoading = false,
            isError = true,
        )
    }

    private fun observeRockets() = acceptChanges(
        getRocketsUseCase()
            .map { result ->
                result.fold(
                    onSuccess = { rocketList ->
                        Fetched(rocketList.map { it.toPresentationModel() })
                    },
                    onFailure = {
                        Error(it)
                    },
                )
            }
            .onStart {
                emit(Loading)
            },
    )

    private fun refreshRockets(): Flow<PartialState> = flow<PartialState> {
        refreshRocketsUseCase()
            .onFailure {
                emit(Error(it))
            }
    }.onStart {
        emit(Loading)
    }

    private fun rocketClicked(uri: String): Flow<PartialState> {
        if (uri.startsWith(HTTP_PREFIX) || uri.startsWith(HTTPS_PREFIX)) {
            publishEvent(OpenWebBrowserWithDetails(uri))
        }

        return emptyFlow()
    }
}
