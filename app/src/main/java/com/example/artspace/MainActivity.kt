package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtWorkLayout()
            }
        }
    }
}
@Composable
fun Buttons(
    @StringRes
    label: Int,
    onClickFun: () -> (Unit),
    modifier: Modifier = Modifier
)
{
    Button(
        onClick = onClickFun,
        modifier = modifier.width(150.dp)
    ) {
        Text(
            text = stringResource(label),
            modifier = modifier
        )
    }
}
@Composable
fun ArtWorkLayout(
    modifier: Modifier = Modifier

)
{
    var index by remember { mutableIntStateOf(0) }
    val artworks = arrayOf(
        R.drawable.artwork_1,
        R.drawable.artwork_2,
        R.drawable.artwork_3,
        R.drawable.artwork_4
    )
    val names = arrayOf(
        R.string.artwork_1,
        R.string.artwork_2,
        R.string.artwork_3,
        R.string.artwork_4
    )
    val artists  = arrayOf(
        R.string.artist_1,
        R.string.artist_2,
        R.string.artist_3,
        R.string.artist_4
    )
    val years = arrayOf(
        R.string.year_1,
        R.string.year_2,
        R.string.year_3,
        R.string.year_4
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Surface(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp),
            shadowElevation = 20.dp,
            color = Color.White

        ) {
            Image(
                painter = painterResource(artworks[index]),
                contentDescription = "Image of a Artwork",
                modifier = Modifier.padding(16.dp)
            )
        }
        Surface(
            modifier = modifier.fillMaxWidth().padding(30.dp).alpha(0.5F),
            color = Color.Gray
        ) {
            Column(
                modifier = modifier.padding(20.dp)
            )
            {
                Text(
                    text = stringResource(names[index]),
                    fontSize = 30.sp,
                    modifier = modifier.align(Alignment.Start)

                )
                Text(
                    text = "${stringResource(artists[index])}(${stringResource(years[index])})",
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        Row(
            modifier = modifier.fillMaxWidth().padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Buttons(
                label = R.string.next,
                onClickFun = {
                    when(index){

                        in 0..(artists.size - 2) -> index++
                        else -> index = 0
                    }
                }
            )
            Buttons(
                label = R.string.previous,
                onClickFun = {
                    when(index)
                    {
                        in 1..(artists.size) -> index--
                        else -> index = 0
                    }
                }
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtWorkLayout()
    }
}