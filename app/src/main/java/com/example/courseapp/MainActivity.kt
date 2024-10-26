package com.example.courseapp


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courseapp.data.DataSource
import com.example.courseapp.model.Topic
import com.example.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}
@Composable
fun CourseApp(modifier : Modifier = Modifier) {
    TopicGrid(topics = DataSource.topics)
}


@Composable
fun TopicGridItem(topic : Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier){
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .size(68.dp)
                    .aspectRatio(1F),
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier) {
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 8.dp
                        )
                    )
                    Text(
                        text = "${topic.courseNumberId}",
                        modifier = Modifier.padding(),
                        style = MaterialTheme.typography.labelMedium

                    )
                }
            }

        }

    }
}

@Composable
fun TopicGrid(topics: List<Topic>, modifier : Modifier = Modifier ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(topics) { topic ->
            TopicGridItem(
                topic = topic
            )
        }
        
    }

}

@Composable
@Preview(showBackground = true)
private fun TopGridItemPreview() {
    CourseAppTheme {
        val topic = Topic(R.string.architecture, courseNumberId = 58, R.drawable.architecture)
        TopicGridItem(topic = topic)
    }
}



