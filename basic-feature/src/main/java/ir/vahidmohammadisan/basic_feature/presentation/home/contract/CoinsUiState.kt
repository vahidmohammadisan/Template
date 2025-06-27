package ir.vahidmohammadisan.basic_feature.presentation.home.contract

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import ir.vahidmohammadisan.basic_feature.presentation.model.CoinDisplayable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class CoinsUiState(
    val isLoading: Boolean = false,
    val coins: List<CoinDisplayable> = emptyList(),
    val isError: Boolean = false,
) : Parcelable {

    sealed class PartialState {
        data object Loading : PartialState() // for simplicity: initial loading & refreshing

        data class Fetched(val list: List<CoinDisplayable>) : PartialState()

        data class Error(val throwable: Throwable) : PartialState()
    }
}
