package com.example.u2_path4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.u2_path4.ui.theme.CodeLabsTutorialsTheme
import com.example.u2_path4.ui.theme.Dusty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceCore(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceCore(modifier: Modifier = Modifier) {
    ArtSpace()
    /* TODO: adapt this to accommodate landscape mode, possibly different screen sizes */
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    // storing the "details" in a list so that they are indexed
    val imageList = rememberSaveable { mutableListOf<ArtPiece>() }
    imageList.add(
        ArtPiece(
            image = R.drawable.image01,
            title = R.string.img01_title,
            description = R.string.img01_description,
            year = R.string._2015
        )
    )
    imageList.add(
        ArtPiece(
            image = R.drawable.image02,
            title = R.string.img02_title,
            description = R.string.img02_description,
            year = R.string._2020
        )
    )
    imageList.add(
        ArtPiece(
            image = R.drawable.image03,
            title = R.string.img03_title,
            description = R.string.img03_description,
            year = R.string._2017
        )
    )
    imageList.add(
        ArtPiece(
            image = R.drawable.image04,
            title = R.string.img04_title,
            description = R.string.img04_description,
            year = R.string._2017
        )
    )

    val imgIndex = rememberSaveable { mutableIntStateOf(0) }

    val idxMax = imageList.size - 1

    Scaffold {

        Column(
            modifier
                    .fillMaxSize()
                    .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier
                        .fillMaxHeight(0.8f)
                        .padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier.fillMaxWidth(0.9f),
                    elevation = CardDefaults.cardElevation(13.dp),
                    border = BorderStroke(Dp.Hairline, color = Dusty)
                ) {

                    Image(
                        painterResource(imageList[imgIndex.intValue].image),
                        contentDescription = stringResource(imageList[imgIndex.intValue].description),
                        modifier
                                .padding(13.dp)
                                .clip(shape = RoundedCornerShape(7.dp)),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Column(/*modifier.fillMaxHeight(0.35f),*/ horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(imageList[imgIndex.intValue].title),
                    modifier = modifier,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = stringResource(imageList[imgIndex.intValue].year), modifier = modifier,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.size(10.dp))
            }

            Column(modifier.padding(bottom = 42.dp)) {
                Row(modifier.fillMaxWidth(0.8f), horizontalArrangement = Arrangement.Absolute.SpaceAround) {
                    ThisButton(title = "Previous", imgIndex = imgIndex, idxMax = idxMax, isNext = false)
                    ThisButton(title = "Next", imgIndex = imgIndex, idxMax = idxMax, isNext = true)
                }
            }
        }
    }
}

@Composable
fun ThisButton(title: String, imgIndex: MutableState<Int>, idxMax: Int, isNext: Boolean, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // check if it was the "Next" or "Previous" button that was clicked
            if (isNext) {
                if (imgIndex.value == idxMax) {
                    imgIndex.value = 0
                } else {
                    imgIndex.value++
                }
            } else {
                if (imgIndex.value == 0) {
                    imgIndex.value = idxMax
                } else {
                    imgIndex.value--
                }
            }
        },
        modifier.size(width = 128.dp, height = 42.dp),
        shape = RoundedCornerShape(13.dp),
        elevation = ButtonDefaults.buttonElevation(7.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Black
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLabsTutorialsTheme {
        ArtSpaceCore()
    }
}