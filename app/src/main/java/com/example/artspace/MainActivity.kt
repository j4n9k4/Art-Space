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
                painter = painterResource(R.drawable.artwork_1),
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
                    text = stringResource(R.string.artwork_1),
                    fontSize = 30.sp,
                    modifier = modifier.align(Alignment.Start)

                )
                Text(
                    text = "${stringResource(R.string.artist_1)}(${stringResource(R.string.year_1)})",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        Row(
            modifier = modifier.fillMaxWidth().padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Buttons(
                label = R.string.next,
                onClickFun = {}
            )
            Buttons(
                label = R.string.previous,
                onClickFun = {}
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