package com.example.instagramprofileui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
    ){
        TopBar(name = "gulnaragallery")
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            modifier = modifier.size(25.dp),
            painter = painterResource(id = R.drawable.baseline_arrow_back),
            contentDescription = "Return back",
            tint = Color.Black
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_notifications),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = modifier.size(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_create),
            contentDescription = "Create",
            tint = Color.Black,
            modifier = modifier.size(30.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_menu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = modifier.size(30.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {

    }
}