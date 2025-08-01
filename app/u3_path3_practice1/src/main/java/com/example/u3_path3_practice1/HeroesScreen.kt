package com.example.u3_path3_practice1

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u3_path3_practice1.ui.theme.Shapes
import com.example.u3_path3_practice1.ui.theme.SuperheroesTheme

@Composable
fun HeroesScreen(modifier: Modifier = Modifier) {

}


@Composable
fun HeroItem(modifier: Modifier = Modifier) {
    val nameRes = R.string.hero1
    val descriptionRes = R.string.description1
    val imageRes = R.drawable.android_superhero1
    Card(
        /* modifier = modifier.fillMaxWidth(), */
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.cardElevation(2.dp),
        /* border = BorderStroke(Dp.Hairline, Black) */
    ) {
        Row(modifier.padding(end = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        // HeroText(nameRes, descriptionRes)
        // HeroImage(imageRes, modifier.size(72.dp).padding(16.dp))

        Column(modifier = modifier
            .padding(16.dp)
            /* .align(Alignment.Start) */) {
            Text(stringResource(nameRes), style = MaterialTheme.typography.displaySmall)
            Text(stringResource(descriptionRes), style = MaterialTheme.typography.bodyLarge)
        }
            Column (modifier = modifier.padding(vertical = 16.dp)/* contentAlignment = Alignment.TopEnd */) {
                Image(
                    painterResource(imageRes), contentDescription = null, modifier = Modifier
                        .clip(shape = Shapes.small)
                        .size(72.dp), contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun HeroText(@StringRes nameRes: Int, @StringRes descriptionRes: Int, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(stringResource(nameRes), style = MaterialTheme.typography.displaySmall)
        Text(stringResource(descriptionRes), style = MaterialTheme.typography.bodyLarge)
    }

}

@Composable
fun HeroImage(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painterResource(imageRes), contentDescription = null, modifier = Modifier
                .clip(shape = Shapes.small)
            /* .size(72.dp) */
        )
    }
}

@Preview
@Composable
private fun HeroItemPreview() {
    SuperheroesTheme{
        HeroItem()
    }
}