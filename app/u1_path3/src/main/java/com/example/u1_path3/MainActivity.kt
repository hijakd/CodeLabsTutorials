package com.example.u1_path3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u1_path3.ui.theme.CodeLabsTutorialsTheme

class MainActivity : ComponentActivity() {
    // val bDayMessage = getString(R.string.happy_birthday)
    val bDayMessage = "Happy Birthday"
    // val bDayFrom = getString(R.string.emma)
    val bDayFrom = "Emma"
    val bDayName = "Android"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                // BirthdayCard(message = bDayMessage, name = bDayName, from = bDayFrom)
                BirthdayCard(message = stringResource(R.string.happy_birthday),
                             name = stringResource(R.string.android),
                             from = stringResource(R.string.emma))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayCard(message: String, name: String, from: String, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        /*topBar = {TopAppBar(title = {Text("Birthday Card App")}, modifier = modifier.height(60.dp), colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary, titleContentColor = MaterialTheme.colorScheme.onPrimary))}*/
            ) { innerPadding ->
        // GreetingText(message = message, name = name, from = from, modifier = Modifier.padding(innerPadding))

        Surface(modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            GreetingImage(message = message, name = name, from = from, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun GreetingText(message: String, name: String, from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "$message $name!", fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(
            text = "${stringResource(R.string.from)} $from",
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 36.sp
            )
    }
}

@Composable
fun GreetingImage(message: String, name: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Surface(modifier.fillMaxSize()) {
        // Box(modifier) {
            // Image(image, contentDescription = null, contentScale = ContentScale.FillBounds)
        Image(image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.7f)
        com.example.u1_path3.GreetingText(message, name, from, modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLabsTutorialsTheme {
        BirthdayCard(message = "Happy Birthday", name = "Sam", from = "Emma")
    }
}