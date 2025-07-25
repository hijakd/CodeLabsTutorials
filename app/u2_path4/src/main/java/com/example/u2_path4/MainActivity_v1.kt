package com.example.u2_path4

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

/*
class MainActivity_v1 {
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
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    */
/* TODO: change the use of separate values for each for conditional assignments *//*

    val idxMax = 3
    val imgIndex = rememberSaveable { mutableIntStateOf(0) }
    var imgResource by rememberSaveable { mutableIntStateOf(R.drawable.felix_20151109) }
    var imgDescription by rememberSaveable { mutableStateOf("") }
    var imgTitle by rememberSaveable { mutableStateOf("") }
    var imgYear by rememberSaveable { mutableStateOf("") }

    when (imgIndex.intValue) {
        0 -> {
            imgResource = (R.drawable.felix_20151109)
            imgDescription = stringResource(R.string.img01_description)
            imgTitle = stringResource(R.string.img01_title)
            imgYear = stringResource(R.string._2015)
        }

        1 -> {
            imgResource = (R.drawable.heart_starter_0200703_192604)
            imgDescription = stringResource(R.string.img02_description)
            imgTitle = stringResource(R.string.img02_title)
            imgYear = stringResource(R.string._2020)
        }

        2 -> {
            imgResource = (R.drawable.leather_mjolnir_0170513_091926)
            imgDescription = stringResource(R.string.img03_description)
            imgTitle = stringResource(R.string.img03_title)
            imgYear = stringResource(R.string._2017)
        }

        else -> {
            imgResource = (R.drawable.imgp0019)
            imgDescription = stringResource(R.string.img04_description)
            imgTitle = stringResource(R.string.img04_title)
            imgYear = stringResource(R.string._2017)
        }
    }
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
                        .padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier.fillMaxWidth(0.9f),
                    elevation = CardDefaults.cardElevation(13.dp),
                    border = BorderStroke(Dp.Hairline, color = Dusty)
                ) {

                    Image(
                        painterResource(imgResource),
                        contentDescription = imgDescription,
                        modifier
                                .padding(13.dp)
                                .clip(shape = RoundedCornerShape(7.dp)),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Column(modifier.fillMaxHeight(0.3f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = imgTitle,
                    modifier = modifier,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = imgYear, modifier = modifier,
                    style = MaterialTheme.typography.bodyLarge
                )
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
    Button(onClick = {
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
    }, modifier.size(width = 128.dp, height = 42.dp), shape = RoundedCornerShape(13.dp)) {
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
*/
