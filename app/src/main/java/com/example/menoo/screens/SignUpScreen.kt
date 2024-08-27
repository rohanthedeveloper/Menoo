package com.example.menoo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.menoo.components.MainButton
import com.example.menoo.components.inputFields
import com.example.menoo.ui.theme.Montserrat

@Preview
@Composable
fun Signupscreen(){
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
            Text(text = "Sign Up", fontFamily = Montserrat, fontSize = 28.sp , fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(76.dp))
            inputFields(name = "Username")
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(name = "Email / Phone")
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(name = "Password")
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(name = "Confirm Password")
            Spacer(modifier = Modifier.height(34.dp))
            MainButton(title = "Sign Up")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Already have an account? Login" , fontFamily = Montserrat , fontSize = 14.sp , fontWeight = FontWeight.Medium)

        }
    }
}