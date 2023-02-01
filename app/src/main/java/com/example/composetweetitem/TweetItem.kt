package com.example.composetweetitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetweetitem.ui.theme.Background

@Preview()
@Composable
fun TweetItem() {
    Column( Modifier
        .fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Background)
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
        com.example.composetweetitem.Divider()
    }
}

@Composable
fun TweetContent() {
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
            fontWeight = FontWeight.Bold,
            text = "Aris", modifier = Modifier.padding(0.dp)
        )
        DefaultText("@ArtistiDevs")
        DefaultText("4h")

        Spacer(modifier = Modifier.weight(1.0f))
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
fun DefaultText(text: String) {
    Text(
        fontSize = 14.sp,
        color = Color.Gray,
        text = text, modifier = Modifier.padding(start = 5.dp)
    )
}

@Composable
fun SocialActions() {
    var commentState by rememberSaveable { mutableStateOf(false) }
    var rtState by rememberSaveable { mutableStateOf(false) }
    var likeState by rememberSaveable { mutableStateOf(false) }

    var commentNumberState by rememberSaveable { mutableStateOf(0) }
    var rtNumberState by rememberSaveable { mutableStateOf(0) }
    var likeNumberState by rememberSaveable { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = Color.Gray,
                painter = painterResource(id = if (commentState) R.drawable.ic_chat_filled else R.drawable.ic_chat),
                contentDescription = null,
                modifier = Modifier.clickable {

                    if (commentState) {
                        commentNumberState--
                    } else {
                        commentNumberState++
                    }
                    commentState = commentState.not()

                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = commentNumberState.toString(),
                modifier = Modifier.padding(start = 5.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = if (rtState) Color.Green else Color.Gray,
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = null,
                modifier = Modifier.clickable {
                    if (rtState) {
                        rtNumberState--
                    } else {
                        rtNumberState++
                    }
                    rtState = rtState.not()
                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = rtNumberState.toString(),
                modifier = Modifier.padding(start = 5.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = if (likeState) Color.Red else Color.Gray,
                painter = painterResource(id = if (likeState) R.drawable.ic_like_filled else R.drawable.ic_like),
                contentDescription = null,
                modifier = Modifier.clickable {
                    if (likeState) {
                        likeNumberState--
                    } else {
                        likeNumberState++
                    }
                    likeState = likeState.not()
                })
            Text(
                fontSize = 13.sp,
                color = Color.Gray,
                text = likeNumberState.toString(),
                modifier = Modifier.padding(start = 5.dp)
            )
        }

    }
}

@Composable
fun Divider() {
    Divider(
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(1.dp)
    )
}