package com.example.u2_path4

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
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
import androidx.compose.runtime.toMutableStateList
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
import com.example.u2_path4.R.drawable.image01
import com.example.u2_path4.R.drawable.image02
import com.example.u2_path4.R.drawable.image03
import com.example.u2_path4.R.drawable.image04
import com.example.u2_path4.R.string._2015
import com.example.u2_path4.R.string._2017
import com.example.u2_path4.R.string._2020
import com.example.u2_path4.R.string.img01_description
import com.example.u2_path4.R.string.img01_title
import com.example.u2_path4.R.string.img02_description
import com.example.u2_path4.R.string.img02_title
import com.example.u2_path4.R.string.img03_description
import com.example.u2_path4.R.string.img03_title
import com.example.u2_path4.R.string.img04_description
import com.example.u2_path4.R.string.img04_title
import com.example.u2_path4.ui.theme.CodeLabsTutorialsTheme
import com.example.u2_path4.ui.theme.Dusty

/*
class MainActivity_v2 : ComponentActivity() {

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

    val imageList = rememberSaveable { mutableListOf<ArtPiece>() }
    imageList.add(ArtPiece(image = image01, title = img01_description, description = img01_title, year = _2015))
    imageList.add(ArtPiece(image = image02, title = img02_description, description = img02_title, year = _2020))
    imageList.add(ArtPiece(image = image03, title = img03_description, description = img03_title, year = _2017))
    imageList.add(ArtPiece(image = image04, title = img04_description, description = img04_title, year = _2017))

    val imgIndex = rememberSaveable { mutableIntStateOf(0) }
    var imgResource by rememberSaveable { mutableIntStateOf(imageList[imgIndex.intValue].image) }
    var imgDescription by rememberSaveable { mutableIntStateOf(imageList[imgIndex.intValue].description) }
    var imgTitle by rememberSaveable { mutableIntStateOf(imageList[imgIndex.intValue].title) }
    var imgYear by rememberSaveable { mutableIntStateOf(imageList[imgIndex.intValue].year) }

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
                        contentDescription = stringResource(imgDescription),
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
                    text = stringResource(imgTitle),
                    modifier = modifier,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = stringResource(imgYear), modifier = modifier,
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