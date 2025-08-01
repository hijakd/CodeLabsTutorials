package com.example.u3_path3_practice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.u3_path3_practice1.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface() {
                    HeroesApp()
                }
            }
        }
    }
}

@Composable
fun HeroesApp(modifier: Modifier = Modifier) {
        HeroesScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.app_name), style = MaterialTheme.typography.displayLarge) },
        // colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        HeroesApp()
    }
}