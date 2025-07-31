package com.example.u3_path3

import android.R.attr.top
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.u3_path3.data.Dog
import com.example.u3_path3.data.dogs
import com.example.u3_path3.ui.theme.RoundBottom
import com.example.u3_path3.ui.theme.Shapes
import com.example.u3_path3.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // CodeLabsTutorialsTheme {
            WoofTheme {
                // Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                //     WoofApp(modifier = Modifier.padding(innerPadding))
                // }
                Surface(modifier = Modifier.fillMaxSize()) { WoofApp() }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@Composable
fun WoofApp(modifier: Modifier = Modifier) {
    Scaffold(topBar = {WoofTopAppBar()}) {it ->
        // LazyColumn() {
        LazyColumn(contentPadding = it) {
            items(dogs) {
                DogItem(dog = it, modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WoofPreview() {
    // CodeLabsTutorialsTheme {
    WoofTheme(darkTheme = true) {
        WoofApp()
    }
}