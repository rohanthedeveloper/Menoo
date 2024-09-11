package com.example.menoo.screens.HomeScreen

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.menoo.R
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Composable
fun HomeScreen(navController: NavController) {
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