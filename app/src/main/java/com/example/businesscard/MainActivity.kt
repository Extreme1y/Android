package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(
                        name = "Alisher Kenzhegaliyev",
                        title = "Junior Android Developer",
                        number = "+7 (701) 686 28 90",
                        media = "@only.kenzh",
                        email = "alisher.kenzhegaliyev@nu.edu.kz"
                    )
                }
            }
        }
    }
}

@Composable
fun Card(
    name: String,
    title: String,
    number: String,
    media: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Surface(color = Color(0xAE6EC572)) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
            )
            {
                Column() {
                    val image =
                        painterResource(id = R.drawable.android_logo)
                    Icon(
                        painter = image,
                        contentDescription = null,
                        tint = Color(0xFF3ddc84),
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .fillMaxHeight(0.2f)
                            .fillMaxWidth(0.4f)
                            .padding(bottom = 16.dp)
                            .background(Color(0xFF182E49))
                    )
                    Text(
                        text = name,
                        fontSize = 35.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = title,
                        fontSize = TextUnit.Unspecified,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17682E),
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Column( modifier = Modifier.align(alignment = Alignment.Center)
                ) {
                    Row(
                        modifier = Modifier.align(alignment = Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_black_24dp),
                            contentDescription = null,
                            tint = Color(0xFF17682E),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(end = 16.dp)
                                .size(18.dp)
                        )
                        Text(
                            text = number,
                            fontSize = TextUnit.Unspecified
                        )
                    }
                    Row(
                        modifier = Modifier
                            .align(alignment = Alignment.Start)
                            .padding(top = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_share_black_24dp),
                            contentDescription = null,
                            tint = Color(0xFF17682E),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(end = 16.dp)
                                .size(18.dp)
                        )
                        Text(
                            text = media,
                            fontSize = TextUnit.Unspecified
                        )
                    }
                    Row(
                        modifier = Modifier
                            .align(alignment = Alignment.Start)
                            .padding(bottom = 32.dp, top = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_black_24dp),
                            contentDescription = null,
                            tint = Color(0xFF17682E),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(end = 16.dp)
                                .size(18.dp)
                        )
                        Text(
                            text = email,
                            fontSize = TextUnit.Unspecified
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Card(
            name = "Alisher Kenzhegaliyev",
            title = "Junior Android Developer",
            number = "+7 (701) 686 28 90",
            media = "@only.kenzh",
            email = "alisher.kenzhegaliyev@nu.edu.kz"
        )
    }
}