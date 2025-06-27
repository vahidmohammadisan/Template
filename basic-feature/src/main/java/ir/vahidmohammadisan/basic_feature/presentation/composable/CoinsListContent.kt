package ir.vahidmohammadisan.basic_feature.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import ir.vahidmohammadisan.basic_feature.presentation.model.CoinDisplayable
import ir.vahidmohammadisan.newtemplate.basicfeature.R

const val COIN_TEST_TAG = "coinTestTag"

@Composable
fun CoinsListContent(
    coinList: List<CoinDisplayable>,
    modifier: Modifier = Modifier,
    onCoinClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_medium),
            ),
    ) {
        itemsIndexed(
            items = coinList,
            key = { _, coin -> coin.id },
        ) { index, item ->
            Text(
                text = item.symbol,
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(id = R.dimen.dimen_small),
                    )
                    .testTag(COIN_TEST_TAG),
            )

            if (index < coinList.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.testTag(COIN_TEST_TAG),
                )
            }
        }
    }
}
