package com.example.menoo.screens.LoginScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.menoo.components.MainButton
import com.example.menoo.components.inputFields
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.menoo.R

//@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier , navController: NavController , viewModel : LoginScreenViewModel = viewModel()) {
    val emailState = rememberSaveable() {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable {
        mutableStateOf("")
    }
    val valid = remember(emailState.value , passwordState.value){
        emailState.value.trim().isNotEmpty() && passwordState.value.trim().isNotEmpty()
    }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
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
            Column {

            }
            inputFields(name = "Email / Phone" , inputState = emailState , keyboardType = KeyboardType.Email)
            Spacer(modifier = Modifier.height(12.dp))
            Column {
                Text(
                    text = "Password",
                    fontFamily = Montserrat,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(
                        0xFF757575
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                TextField(modifier = Modifier
                    .height(50.dp)
                    .width(300.dp)
                    .border(1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
                    value = passwordState.value,
                    onValueChange = { passwordState.value = it },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions.Default,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(
                            onClick = { isPasswordVisible = !isPasswordVisible }
                        ) {
                            val painter =
                                if (isPasswordVisible) painterResource(id = R.drawable.eye) else painterResource(
                                    id = R.drawable.invisible
                                )
                            Icon(
                                painter = painter,
                                contentDescription = "Toggle Password Visibility",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            MainButton("Login" , onClick = {
                if(valid){
                    viewModel.loginUserWithEmailandPassword(emailState.value , passwordState.value){
                        navController.navigate(MenooScreens.HomeScreen.name)
                    }
                }
                else{
                    Toast.makeText(context , "Invalid Credentials" , Toast.LENGTH_SHORT).show()
                }
            })
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Forgot Password", style = TextStyle(textDecoration = TextDecoration.Underline),fontFamily = Montserrat, fontSize = 14.sp , fontWeight = FontWeight.Medium, color = Color(
                0xFF757575
            ))
            Spacer(modifier = Modifier.height(79.dp))
            Row {
                Text(
                    text = "Don't have an account?",
                    fontFamily = Montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.clickable{ navController.navigate(MenooScreens.SignUpScreen.name) },
                    text = "Sign Up",
                    fontFamily = Montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                )
            }
        }
    }
}





