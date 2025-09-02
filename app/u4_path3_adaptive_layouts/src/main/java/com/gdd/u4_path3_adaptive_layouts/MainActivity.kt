package com.gdd.u4_path3_adaptive_layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.gdd.u4_path3_adaptive_layouts.ui.ReplyApp
import com.gdd.u4_path3_adaptive_layouts.ui.theme.CodeLabsTutorialsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
                    modifier = Modifier.padding(
                        start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
                        end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection)
                    )
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    ReplyApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    CodeLabsTutorialsTheme {
        Surface {
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppMediumPreview() {
    CodeLabsTutorialsTheme {
        Surface {
            ReplyApp(windowSize = WindowWidthSizeClass.Medium)
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppExpandedPreview() {
    CodeLabsTutorialsTheme {
        Surface {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}