package com.example.instagramprofileui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "gulllnaara_azizzova_gallery", modifier = Modifier
            .padding(10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(20.dp))
        ButtonsSection()
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
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_notifications),
            contentDescription = "Notifications",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_create),
            contentDescription = "Notifications",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_menu),
            contentDescription = "Notifications",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundProfilePhoto(
                image = painterResource(id = R.drawable.prof_photo),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            fullName = "Gulnara Azizova \uD83D\uDC8C",
            description = "ada||bsit \uD83C\uDF93 \n" +
                    "photography and design enthusiast||kpop and kdrama lover ✨\n" +
                    "Android Mobile Development Enthusiast \uD83D\uDCF1 \n" +
                    "꿈만 꾸지말고 꿈이되어라 \uD83D\uDD2E",
            url = "https://github.com/gazizovaa",
            followedBy = listOf("j.m", "nialhoran"),
            otherFollowers = 54
        )
    }
}

@Composable
fun RoundProfilePhoto(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )
            .padding(2.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStatus(numberText = "11", text = "Posts")
        ProfileStatus(numberText = "485", text = "Followers")
        ProfileStatus(numberText = "828", text = "Following")
    }
}

@Composable
fun ProfileStatus(
    numberText: String,
    text: String,
    modifier: Modifier =  Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun ProfileDescription(
    fullName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherFollowers: Int
){
    val letterSpacing =  0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = fullName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            color = Color.White,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            Text(
                color = Color.White,
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index < followedBy.size - 1){
                            append(", ")
                        }
                    }
                    if(otherFollowers > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherFollowers others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonsSection(
    modifier: Modifier = Modifier
){
    val minWidth = 140.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
                .background(Color.Black)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
                .background(Color.Black)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height = height)
                .background(Color.Black)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if(text != null){
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp
            )
        }

        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}


