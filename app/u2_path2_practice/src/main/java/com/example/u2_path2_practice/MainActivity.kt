package com.example.u2_path2_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u2_path2_practice.ui.theme.CodeLabsTutorialsTheme
import com.example.u2_path2_practice.ui.theme.MintGreen
import com.example.u2_path2_practice.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Lemonade", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
                        }, colors = TopAppBarDefaults.topAppBarColors(Yellow))
                    }) { innerPadding ->
                    LemonadeCore(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LemonadeCore(modifier: Modifier = Modifier) {

    LemonadeApp()
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var lemonadeStep by remember { mutableIntStateOf(1) }
    var txtString by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageResource: Painter
    var timesToSqueeze by remember { mutableIntStateOf(0) }
    var squeezed by remember { mutableIntStateOf(0) }

    /*val txtString = when (lemonadeStep) {
        1 -> stringResource(R.string.tap_to_pick)
        2 -> stringResource(R.string.tap_to_squeeze)
        3 -> stringResource(R.string.tap_to_drink)
        else -> stringResource(R.string.tap_to_restart)
    }
    val imageResource = when (lemonadeStep) {
        1 -> painterResource(R.drawable.lemon_tree)
        2 -> painterResource(R.drawable.lemon_squeeze)
        3 -> painterResource(R.drawable.lemon_drink)
        else -> painterResource(R.drawable.lemon_restart)
    }
    val description = when (lemonadeStep) {
        1 -> stringResource(R.string.lemon_tree)
        2 -> stringResource(R.string.lemon)
        3 -> stringResource(R.string.glass_lemonade)
        else -> stringResource(R.string.empty_glass)
    }*/

    when (lemonadeStep) {
        1 -> {
            txtString = stringResource(R.string.tap_to_pick)
            description = stringResource(R.string.lemon_tree)
            imageResource = painterResource(R.drawable.lemon_tree)
        }

        2 -> {
            txtString = stringResource(R.string.tap_to_squeeze)
            description = stringResource(R.string.lemon)
            imageResource = painterResource(R.drawable.lemon_squeeze)
            timesToSqueeze = (2..4).random()
        }

        3 -> {
            txtString = stringResource(R.string.tap_to_drink)
            description = stringResource(R.string.glass_lemonade)
            imageResource = painterResource(R.drawable.lemon_drink)
        }

        else -> {
            txtString = stringResource(R.string.tap_to_restart)
            description = stringResource(R.string.empty_glass)
            imageResource = painterResource(R.drawable.lemon_restart)
        }
    }

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Surface(shape = RoundedCornerShape(30.dp), color = MintGreen, shadowElevation = 7.dp, onClick = {
            if (lemonadeStep == 2 && squeezed < timesToSqueeze){
                squeezed++
            } else if (lemonadeStep > 3){
                lemonadeStep = 1
            } else {
                lemonadeStep++
            }
        }) {
            Image(
                painter = imageResource,
                contentDescription = description, modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(text = txtString, modifier = modifier, fontSize = 18.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CodeLabsTutorialsTheme {
        LemonadeCore()
    }
}