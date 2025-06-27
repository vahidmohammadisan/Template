package ir.vahidmohammadisan.basic_feature.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsEvent
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsEvent.OpenWebBrowserWithDetails
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsIntent
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsIntent.RefreshCoins
import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsUiState
import ir.vahidmohammadisan.basic_feature.presentation.home.CoinsViewModel
import ir.vahidmohammadisan.core.utils.collectWithLifecycle
import ir.vahidmohammadisan.newtemplate.basicfeature.R
import kotlinx.coroutines.flow.Flow

@Composable
fun CoinsRoute(
    viewModel: CoinsViewModel = hiltViewModel(),
) {
    HandleEvents(viewModel.event)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RocketsScreen(
        uiState = uiState,
        onIntent = viewModel::acceptIntent,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RocketsScreen(
    uiState: CoinsUiState,
    onIntent: (CoinsIntent) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val pullToRefreshState = rememberPullToRefreshState()

    HandlePullToRefresh(
        pullState = pullToRefreshState,
        uiState = uiState,
        onIntent = onIntent,
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .nestedScroll(pullToRefreshState.nestedScrollConnection),
        ) {
            if (uiState.coins.isNotEmpty()) {
                RocketsAvailableContent(
                    snackbarHostState = snackbarHostState,
                    uiState = uiState,
                    onRocketClick = { onIntent(CoinsIntent.CoinClicked(it)) },
                )
            } else {
                RocketsNotAvailableContent(
                    uiState = uiState,
                )
            }

            PullToRefreshContainer(
                state = pullToRefreshState,
                modifier = Modifier
                    .align(Alignment.TopCenter),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HandlePullToRefresh(
    pullState: PullToRefreshState,
    uiState: CoinsUiState,
    onIntent: (CoinsIntent) -> Unit,
) {
    if (pullState.isRefreshing) {
        LaunchedEffect(true) {
            onIntent(RefreshCoins)
        }
    }

    if (uiState.isLoading.not()) {
        LaunchedEffect(true) {
            pullState.endRefresh()
        }
    }
}

@Composable
private fun HandleEvents(events: Flow<CoinsEvent>) {
    val uriHandler = LocalUriHandler.current

    events.collectWithLifecycle {
        when (it) {
            is OpenWebBrowserWithDetails -> {
                uriHandler.openUri(it.uri)
            }
        }
    }
}

@Composable
private fun RocketsAvailableContent(
    snackbarHostState: SnackbarHostState,
    uiState: CoinsUiState,
    onRocketClick: (String) -> Unit,
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.coins_error_refreshing)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage,
            )
        }
    }

    CoinsListContent(
        coinList = uiState.coins,
        onCoinClick = onRocketClick,
    )
}

@Composable
private fun RocketsNotAvailableContent(uiState: CoinsUiState) {
    when {
        uiState.isLoading -> CoinsLoadingPlaceholder()
        uiState.isError -> CoinsErrorContent()
    }
}
