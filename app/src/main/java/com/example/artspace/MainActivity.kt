package com.example.artspace

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

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
                    ArtSpacePreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.chloe_martin_unsplash
        else -> R.drawable.kenneth_coffie_unsplash
    }

    var res by remember { mutableStateOf(1) }
    val titles = when (res) {
        1 -> R.string.chloe_martin_title
        else -> R.string.kenneth_coffie_title
    }

    var r by remember { mutableStateOf(1) }
    val authors = when (r) {
        1 -> R.string.chloe_martin_year
        else -> R.string.kenneth_coffie_year
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.padding(top = 80.dp)) {
            Surface(
                shadowElevation = 12.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = result.toString(),
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .padding(16.dp)
                    )
                }
            }
        }
        Box(modifier = Modifier.padding(top = 48.dp)) {
            Surface(
                color = Color(0xFFBCD2FF),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Column (modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = titles),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = stringResource(id = authors),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp).fillMaxWidth()) {
            Button(
                onClick = {
                    result--
                    res--
                    r--
                    if (result < 1) {
                        result = 2
                    }
                    if (res < 1) {
                        res = 2
                    }
                    if (r < 1) {
                        r = 2
                    }
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF4556E9),
                    Color(0xFFFFFFFF),
                    Color(0xFF4556E9),
                    Color(0xFF4556E9)
                ),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(text = "Previous", textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp))
            }

            Button(
                onClick = {
                    result++
                    res++
                    r++
                    if (result > 2) {
                        result = 1
                    }
                    if (res > 2) {
                        res = 1
                    }
                    if (r > 2) {
                        r = 1
                    }
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF4556E9),
                    Color(0xFFFFFFFF),
                    Color(0xFF4556E9),
                    Color(0xFF4556E9),
                ),
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = "  Next  ", textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp))
            }
        }
    }
}