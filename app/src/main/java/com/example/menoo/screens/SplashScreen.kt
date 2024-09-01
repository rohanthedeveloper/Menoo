package com.example.menoo.screens

import android.window.SplashScreen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.menoo.R
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat
import com.example.menoo.ui.theme.Typography
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.delay
import java.lang.reflect.Type


@Composable
fun SplashScreen(modifier: Modifier = Modifier , navController: NavController) {
    var user by remember { mutableStateOf(Firebase.auth.currentUser)}
    LaunchedEffect(key1 = true) {
        //startAnimation = true
        delay(2000L)
        if (user == null){
            navController?.navigate(MenooScreens.LoginScreen.name)
        }
        else{
            navController?.navigate(MenooScreens.HomeScreen.name)
        }
//        navController?.navigate(MenooScreens.LoginScreen.name)
    }
    Splash()
}
@Composable
fun Splash(){
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F5E9),
                        Color(0xFFC5E1A5)
                    )
                )
            ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
            Spacer(modifier = Modifier.height(344.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Montserrat
            )
            Spacer(modifier = Modifier.height(303.dp))
            Text(
                text = "a project by \n VIIT students",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Montserrat
            )
        }
    }
}

