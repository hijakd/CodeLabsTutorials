package com.example.u3_path3_practice1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u3_path3_practice1.model.HeroesRepository
import com.example.u3_path3_practice1.ui.theme.Shapes
import com.example.u3_path3_practice1.ui.theme.SuperheroesTheme

@Composable
fun HeroesScreen(modifier: Modifier = Modifier) {
    val heroes = HeroesRepository.heroes

    Scaffold(topBar = {HeroesAppBar()}) { it ->
        LazyColumn(modifier.padding(horizontal = dimensionResource(R.dimen.padding)), contentPadding = it) {
            items(heroes) {
                HeroItem(it.nameRes, it.descriptionRes, it.imageRes)
            }
        }
    }
}


@Composable
fun HeroItem(@StringRes nameRes: Int, @StringRes descriptionRes: Int, @DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    // val nameRes = R.string.hero1
    // val descriptionRes = R.string.description1
    // val imageRes = R.drawable.android_superhero1

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = Shapes.medium,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation)),
        // border = BorderStroke(Dp.Hairline, Black)
    ) {
        Row(
            modifier = modifier.padding(end = dimensionResource(R.dimen.padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier.padding(start = dimensionResource(R.dimen.padding)),
                contentAlignment = Alignment.CenterStart
            ) { HeroText(nameRes, descriptionRes) }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding)))
            Box(
                modifier = modifier
                    .padding(vertical = dimensionResource(R.dimen.padding))
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) { HeroImage(imageRes, modifier = modifier.width(72.dp)) }
        }
    }
}

@Composable
fun HeroText(@StringRes nameRes: Int, @StringRes descriptionRes: Int, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(stringResource(nameRes), style = MaterialTheme.typography.displaySmall)
        Text(stringResource(descriptionRes), style = MaterialTheme.typography.bodyLarge, modifier = modifier.fillMaxWidth(0.7f))
    }
}

@Composable
fun HeroImage(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painterResource(imageRes), contentDescription = null, modifier = Modifier
                .clip(shape = Shapes.small)
                .size(dimensionResource(R.dimen.imageSize)), contentScale = ContentScale.Crop
        )
    }
}

// @Preview
// @Composable
// private fun HeroItemPreview() {
//     SuperheroesTheme {
//         HeroItem(nameRes = R.string.hero1, descriptionRes = R.string.description1, imageRes = R.drawable.android_superhero1)
//     }
// }

@Preview
@Composable
private fun HeroListPreview() {
    SuperheroesTheme(darkTheme = true) {
        HeroesScreen()
    }
}