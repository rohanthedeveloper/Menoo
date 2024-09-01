package com.example.menoo.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.menoo.components.MainButton
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun HomeScreen(navController: NavController) {
    val auth : FirebaseAuth = Firebase.auth
    var user by remember { mutableStateOf(auth.currentUser) }
    Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center ,modifier = Modifier
        .fillMaxSize()
        //.verticalScroll(scrollState)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFE8F5E9),
                    Color(0xFFC5E1A5)
                )
            )
        )
    ){
        Text(text = "Welcome", fontSize = 60.sp , fontFamily = Montserrat , fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        MainButton("Sign Out" , onClick =  {auth.signOut()
            user = null
            navController.navigate(MenooScreens.LoginScreen.name)
        })
    }
}