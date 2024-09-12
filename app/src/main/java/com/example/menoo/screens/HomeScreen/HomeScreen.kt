package com.example.menoo.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.menoo.R
import com.example.menoo.components.catogoryCard
import com.example.menoo.components.optionButton
import com.example.menoo.model.Menu
import com.example.menoo.model.Mess
import com.example.menoo.model.catogories
import com.example.menoo.model.menuList
import com.example.menoo.model.messList
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat


@Composable
fun HomeScreen(navController: NavController , mess : List<Mess> = messList) {
    var clicked = false
    var color = Color(0xFFFFD748)
//    if(!clicked){
//        color = Color(0xFFFFD748)
//    }
//    else{
//        color = Color(0xFFFFD748)
//    }
    Spacer(modifier = Modifier.height(30.dp))
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE8F5E9),
                            Color(0xFFC5E1A5)
                        )
                    )
                )
        ) {
            Spacer(modifier = Modifier.height(45.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Menoo",
                    fontSize = 36.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(
                        0xFFF6B202
                    ),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Spacer(modifier = Modifier.width(140.dp))
                IconButton(onClick = { navController.navigate(MenooScreens.ProfileScreen.name) }) {
                    Image(
                        painter = painterResource(R.drawable.test_account),
                        contentDescription = "profile",
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.height(9.dp))
            SearchBar(navController = navController)
            Spacer(modifier = Modifier.height(22.dp))
            Row {
                //Spacer(modifier = Modifier.width(30.dp))
                optionButton(
                    title = "Mess" ,
                    onClick = {} ,
                    modifier = Modifier.padding(start = 30.dp , end = 30.dp).height(40.dp).width(125.dp)
                )
                //Spacer(modifier = Modifier.width(155.dp))
                optionButton(
                    title = "Tiffin" ,
                    onClick = {} ,
                    modifier = Modifier.padding(start = 30.dp , end = 30.dp).height(40.dp).width(125.dp)
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            LazyRow(state = rememberLazyListState()) {
                items(catogories){ it ->
                    catogoryCard(
                        title = it ,
                    )
                }
            }
            Spacer(modifier = Modifier.height(39.dp))
            LazyColumn {
                items(messList){ it ->
                    messCard(name = it.name , item1 = it.item1 , item2 = it.item2)
                }
            }
        }
    }
}

//@Preview
@Composable
fun SearchBar(navController: NavController) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(40.dp)
            .width(302.dp)
            .border(1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .clickable { navController.navigate(MenooScreens.SearchScreen.name) }
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.search_icon) , contentDescription = "search", modifier = Modifier.padding(start = 16.dp).height(23.dp).width(20.dp) )
            Spacer(modifier = Modifier.width(77.dp))
            Text("Search" , fontSize = 18.sp , fontFamily = Montserrat , fontWeight = FontWeight.SemiBold , color = Color(
                0xFF4D4B4B
            )
            )
        }
    }
}

//@Preview
@Composable
fun messCard(name : String , item1 : String , item2 : String ) {
    Card(modifier = Modifier
        .padding(bottom = 29.dp)
        .width(327.dp)
        .height(180.dp)
        .background(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(size = 8.dp)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(18.dp))
            Row() {
                Surface(
                    modifier = Modifier
                        .padding(start = 23.dp)
                        .height(19.dp)
                        .width(52.dp)
                        .border(1.dp, color = Color(0xFFFF2508), shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Closed",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = Montserrat,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.width(180.dp))
                Image(
                    painter = painterResource(R.drawable.location_icon),
                    contentDescription = "Locate",
                    modifier = Modifier.width(32.dp).height(17.dp)
                )
                Image(
                    painter = painterResource(R.drawable.share_icon),
                    contentDescription = "Share",
                    modifier = Modifier.width(32.dp).height(17.dp)
                )
            }
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(800),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.padding(start = 30.dp, top = 2.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Today’s Menu",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF4D4B4B),
                ),
                modifier = Modifier.padding(start = 37.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.padding(start = 42.dp)) {
                Text(
                    item1,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF000000),

                        )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    item2,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF000000),

                        )
                )
            }
            Spacer(modifier = Modifier.height(9.dp))
            Row() {
                Spacer(modifier = Modifier.width(205.dp))
            Surface(
                modifier = Modifier
                    //.padding(30.dp)
                    .width(91.dp)
                    .height(23.dp),
                color = Color(0xFFFFD748),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "See Pricing",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = Montserrat,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }
            }
        }
        }
    }
}


