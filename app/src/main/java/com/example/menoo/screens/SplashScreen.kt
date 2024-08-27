package com.example.menoo.screens

import android.window.SplashScreen
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import kotlinx.coroutines.delay
import java.lang.reflect.Type


@Composable
fun SplashScreen(modifier: Modifier = Modifier , navController: NavController = rememberNavController()){

    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.navigate(MenooScreens.LoginScreen.name)
    }
    Surface(color = Color(0xFFFFD748), modifier = Modifier.fillMaxSize()) {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(300.dp))
            Text(
                text = "a project by \n VIIT students",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

