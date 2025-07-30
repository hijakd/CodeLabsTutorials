@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.u3_path2_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u3_path2_practice.data.DataSource
import com.example.u3_path2_practice.data.Topic
import com.example.u3_path2_practice.ui.theme.CodeLabsTutorialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabsTutorialsTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        ) { innerPadding ->
                    CourseTopicsApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CourseTopicsApp(modifier: Modifier = Modifier) {
    CourseGrid(topicsList = DataSource.topics)
}

@Composable
fun CourseItem(@StringRes topicName: Int, @DrawableRes imageResource: Int, courseCount: Int, modifier: Modifier = Modifier) {
    Card() {
        Row {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(topicName),
                modifier = modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
                 )
            // Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Column(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))) {
                Text(
                    stringResource(topicName),
                    // modifier = Modifier.padding(top = 16.dp),
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_medium)),
                    style = MaterialTheme.typography.bodyMedium
                    )
                // Row(modifier = Modifier.padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                Row(
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
                    verticalAlignment = Alignment.CenterVertically
                   ) {
                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null)
                    Text(
                        courseCount.toString(),
                        // modifier = Modifier.padding(start = 8.dp),
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small)),
                        style = MaterialTheme.typography.labelMedium
                        )
                }
            }
        }
    }
}

@Composable
fun CourseGrid(topicsList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        // horizontalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        // verticalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        // contentPadding = PaddingValues(8.dp)
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small))
                    ) {
        items(topicsList) { topic ->
            CourseItem(topic.name, topic.image, topic.associatedCourseCount)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLabsTutorialsTheme {
        CourseTopicsApp()
    }
}

// @Preview
// @Composable
// fun CourseItemPreview() {
//     // CodeLabsTutorialsTheme {
//     CourseItem(R.string.architecture, R.drawable.architecture, 58)
//     // }
// }