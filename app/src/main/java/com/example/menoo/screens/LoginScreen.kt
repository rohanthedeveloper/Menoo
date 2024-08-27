package com.example.menoo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.util.TableInfo
import com.example.menoo.components.MainButton
import com.example.menoo.components.inputFields
import com.example.menoo.ui.theme.Montserrat

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier , navController: NavController = rememberNavController()) {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F5E9),
                        Color(0xFFC5E1A5)
                    )
                )
            )) {
            Spacer(modifier = Modifier.height(138.dp))
            Text(text = "Login", fontFamily = Montserrat, fontSize = 28.sp , fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(76.dp))
            inputFields(name = "Email / Phone")
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(name = "Password")
            Spacer(modifier = Modifier.height(40.dp))
            MainButton("Login")
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Forgot Password", style = TextStyle(textDecoration = TextDecoration.Underline),fontFamily = Montserrat, fontSize = 14.sp , fontWeight = FontWeight.Medium, color = Color(
                0xFF757575
            ))
            Spacer(modifier = Modifier.height(79.dp))
            Text(text = "Don't have an account? Sign Up" , fontFamily = Montserrat , fontSize = 14.sp , fontWeight = FontWeight.Medium)

        }
    }
}



