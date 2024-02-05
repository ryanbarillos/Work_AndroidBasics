package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting()
                }
            }
        }
    }
}
/*
Assignment 01
By Ryan Barillos

Date Started: 04 Feb 2024
Day Finished: 04 Feb 2024

NOTE:
If there are rendering issues, that's a problem with Android Studio,
not the code. Just build the app on your phone and nothing wrong will happen

 */

/*
REFERENCES

Making rounded box
https://coding-world.kaleidosstudio.com/jetpack-compose/how-to-create-rounded-corner-shape-with-jetkack-compose-1649761146043

Images Used:
https://www.flaticon.com/free-icon/android_5969040
https://www.flaticon.com/free-icon/linkedin_145807
https://www.flaticon.com/free-icon/mail_9068642
https://www.flaticon.com/free-icon/telephone_724664
 */

@Composable
fun ContactInfo(img: Painter, imgDesc: String, info: String) {
    Box(Modifier.padding(4.dp)) {
        Row {
            Image(
                painter = img,
                contentDescription = imgDesc,
                Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = info
            )
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val txtId = arrayOf(
        "Ryan Barillos",
        "Software Developer"
    )
    val txtContact = arrayOf(
        "+123 456 7890",
        "@insert_username",
        "a@a.com"
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = "Photo of person",
                )
                Text(
                    text = txtId[0],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Text(
                    text = txtId[1],
                )
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        Box(contentAlignment = Alignment.Center) {
            Column {
                ContactInfo(
                    img = painterResource(id = R.drawable.phone),
                    imgDesc = "Phone number",
                    info = txtContact[0]
                )
                ContactInfo(
                    img = painterResource(id = R.drawable.linkedin),
                    imgDesc = "LinkedIn",
                    info = txtContact[1]
                )
                ContactInfo(
                    img = painterResource(id = R.drawable.mail),
                    imgDesc = "Email",
                    info = txtContact[2]
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting()
    }
}