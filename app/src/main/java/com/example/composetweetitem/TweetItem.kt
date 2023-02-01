package com.example.composetweetitem

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetweetitem.ui.theme.Background

@Preview()
@Composable
fun TweetItem() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp).background(Background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Item",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            TweetInfo()
            TweetContent()
            SocialActions()
        }
    }
}

@Composable
fun TweetContent(){
    Text(
        color = Color.White,
        text = "Texto descricicon infernal del averno en tu cara si señor que tal va con un texto mas largo para que salte de linea y tal",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
    )

    Image(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.profile),
        contentDescription = null
    )
}

@Composable
fun TweetInfo() {
    Row(modifier = Modifier.padding(horizontal = 0.dp)) {
        Text(
            color = Color.White,
            fontSize = 14.sp,
            // color = Color.White,
            fontWeight = FontWeight.SemiBold,
            text = "Aris", modifier = Modifier.padding(0.dp)
        )
        Text(
            fontSize = 14.sp,
            color = Color.Gray,
            text = "@ArtistiDevs", modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            fontSize = 14.sp,
            color = Color.Gray,
            text = "4h", modifier = Modifier
                .padding(start = 5.dp)
                .weight(1.0f)
        )
        //val activity = LocalContext.current as Activity
        Icon(
            tint = Color.White,
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            modifier = Modifier
                .rotate(90f)
                .clickable {

                })
    }
}

@Composable
fun SocialActions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = Color.Gray,
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = null,
                modifier = Modifier.clickable {
//Todo  var state by rememberSaveable { mutableStateOf(true) }
                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = "1",
                modifier = Modifier.padding(start = 5.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = Color.Gray,
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = null,
                modifier = Modifier.clickable {

                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = "2",
                modifier = Modifier.padding(start = 5.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = Color.Gray,
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = null,
                modifier = Modifier.clickable {

                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = "3",
                modifier = Modifier.padding(start = 5.dp)
            )
        }

    }
}