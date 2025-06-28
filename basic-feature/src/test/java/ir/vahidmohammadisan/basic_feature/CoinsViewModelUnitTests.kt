//import androidx.lifecycle.SavedStateHandle
//import io.mockk.mockk
//import ir.vahidmohammadisan.basic_feature.domain.usecase.GetCoinsUseCase
//import ir.vahidmohammadisan.basic_feature.domain.usecase.RefreshCoinsUseCase
//import ir.vahidmohammadisan.basic_feature.presentation.home.CoinsViewModel
//import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsEvent
//import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsIntent
//import ir.vahidmohammadisan.basic_feature.presentation.home.contract.CoinsUiState
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Test
//
//@OptIn(ExperimentalCoroutinesApi::class)
//class CoinsViewModelTest {
//
//    private lateinit var getCoinsUseCase: GetCoinsUseCase
//    private lateinit var refreshCoinsUseCase: RefreshCoinsUseCase
//    private lateinit var viewModel: CoinsViewModel
//
//    @Before
//    fun setUp() {
//        getCoinsUseCase = mockk()
//        refreshCoinsUseCase = mockk()
//        viewModel = CoinsViewModel(
//            getCoinsUseCase,
//            refreshCoinsUseCase,
//            SavedStateHandle(),
//            CoinsUiState()
//        )
//    }
//
//    @Test
//    fun `mapIntents with CoinClicked publishes event for https url`() = runTest {
//        val eventList = mutableListOf<CoinsEvent>()
//        viewModel.events.observeForever { eventList.add(it) }
//        viewModel.mapIntents(CoinsIntent.CoinClicked("https://test.com"))
//        assertTrue(eventList.any { it is CoinsEvent.OpenWebBrowserWithDetails })
//    }
//
//    @Test
//    fun `mapIntents with CoinClicked does not publish event for non-http url`() = runTest {
//        val eventList = mutableListOf<CoinsEvent>()
//        viewModel.events.observeForever { eventList.add(it) }
//        viewModel.mapIntents(CoinsIntent.CoinClicked("ftp://test.com"))
//        assertFalse(eventList.any { it is CoinsEvent.OpenWebBrowserWithDetails })
//    }
//
//    @Test
//    fun `reduceUiState updates state correctly on loading`() {
//        val previousState = CoinsUiState()
//        val partialState = CoinsUiState.PartialState.Loading
//        val newState = viewModel.reduceUiState(previousState, partialState)
//        assertTrue(newState.isLoading)
//        assertFalse(newState.isError)
//    }
//
//    @Test
//    fun `reduceUiState updates state correctly on fetched`() {
//        val previousState = CoinsUiState()
//        val coins = listOf("Bitcoin", "Ethereum")
//        val partialState = CoinsUiState.PartialState.Fetched(coins)
//        val newState = viewModel.reduceUiState(previousState, partialState)
//        assertFalse(newState.isLoading)
//        assertEquals(coins, newState.coins)
//        assertFalse(newState.isError)
//    }
//
//    @Test
//    fun `reduceUiState updates state correctly on error`() {
//        val previousState = CoinsUiState()
//        val partialState = CoinsUiState.PartialState.Error
//        val newState = viewModel.reduceUiState(previousState, partialState)
//        assertFalse(newState.isLoading)
//        assertTrue(newState.isError)
//    }
//}