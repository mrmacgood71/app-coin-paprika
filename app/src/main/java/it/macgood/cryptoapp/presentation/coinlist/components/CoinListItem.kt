package it.macgood.cryptoapp.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import it.macgood.cryptoapp.domain.model.Coin
import it.macgood.cryptoapp.domain.model.CoinPrice

@Composable
fun CoinListItem(
    coin: Coin,
    coinPrice: CoinPrice,
    onItemClick: (Coin) -> Unit
) {
    val active = Color(0xFF04C269)
    val inactive = Color(0xFF7D7D7D)
    val scroll = rememberScrollState(0)

    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(coin) }
            .padding(16.dp)
            .horizontalScroll(scroll),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
        )
        Row(
            modifier = Modifier.align(CenterVertically)
        ) {
            Text(
                text = if (coin.isActive) "${coinPrice.open}" else "inactive",
                color = Color(0xA0FFFABE),
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(CenterVertically).padding(start = 4.dp, end = 20.dp)
            )

            Text(
                text = if (coin.isActive) "active" else "inactive",
                color = if (coin.isActive) active else inactive,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(CenterVertically)
            )
        }


    }

}