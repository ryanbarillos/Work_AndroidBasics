package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.data.Datasource
import com.example.artspace.model.Art
import com.example.artspace.ui.theme.ArtSpaceTheme
import javax.sql.DataSource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip

/*
Art Space
By Ryan Barillos

Date Started: 24 Feb 2024
Day Finished: 25 Feb 2024
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtCard(art: Art) {
    val cornerRadius = 16.dp
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        /*
        Art Image
         */
        Surface(
            shape = RoundedCornerShape(cornerRadius),
            shadowElevation = 8.dp
        ) {
            Image(
                painter = painterResource(id = art.artPhoto),
                contentDescription = stringResource(id = art.artTitle),
                modifier = Modifier
                    .size(330.dp)
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(cornerRadius))
            )
        }
        Spacer(modifier = Modifier.height(72.dp))
        /*
        Art Description
         */
        Surface(
            color = Color.hsl(
                hue = 247F,
                saturation = .29F,
                lightness = .94F
            ),
            modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = art.artTitle),
                    style = MaterialTheme.typography.headlineSmall
                )
                Box {
                    Row {
                        // Author
                        Text(
                            text = stringResource(id = art.artAuthor),
                            style = MaterialTheme.typography.labelLarge
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        // Year
                        Text(
                            text = "(${art.artYear})",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

/*
PLAN:

Save the photo index outside of the ArtSpace function
And just call this function instead to get current index.

This is to not reset the "pageNow" to zero  (0) on screen rotation.

However, my efforts have failed, thus it's not in use
 */
//@Composable
//fun getPageLast(pageMax: Int, state: String = "none"): Int {
//    var lastPage by remember { mutableIntStateOf(0) }
//
//    if (state == "next") {
//        if (lastPage < pageMax) lastPage++
//        else lastPage = 0
//    } else if (state == "prev") {
//        if (lastPage > 0) lastPage--
//        else lastPage = pageMax
//    }
//
//    return lastPage
//}


@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    val pageMax: Int = Datasource.arts.size - 1
    var pageNow by remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Art
        ArtCard(Datasource.arts[pageNow])
        Spacer(modifier = Modifier.height(32.dp))
        //Navigation
        Row{
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                if (pageNow > 0) pageNow--
                else pageNow = pageMax
            }) {
                Text(stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.weight(.5F))
            Button(
                modifier = Modifier.weight(1F),
                onClick = {
                if (pageNow < pageMax) pageNow++
                else pageNow = 0
            }) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}