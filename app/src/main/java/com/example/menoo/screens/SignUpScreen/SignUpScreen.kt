package com.example.menoo.screens.SignUpScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.menoo.components.MainButton
import com.example.menoo.components.inputFields
import com.example.menoo.navigation.MenooScreens
import com.example.menoo.ui.theme.Montserrat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.menoo.R
import com.example.menoo.screens.HomeScreen
import kotlinx.coroutines.delay

//@Preview
@Composable
fun SignUpscreen(navController: NavController = rememberNavController(), viewModel: SignUpScreenViewModel = viewModel()){
    val userNameState = rememberSaveable {
        mutableStateOf("")
    }
    val emailState = rememberSaveable() {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable() {
        mutableStateOf("")
    }
    val confirmPasswordState = rememberSaveable() {
        mutableStateOf("")
    }
    val valid = remember(emailState.value , passwordState.value , userNameState.value , confirmPasswordState.value){
        emailState.value.trim().isNotEmpty() && passwordState.value.trim().isNotEmpty() && userNameState.value.trim().isNotEmpty() && confirmPasswordState.value.trim().isNotEmpty()
    }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val passwordFocusRequester = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding() // Adjust padding automatically for keyboard
            //.padding(16.dp) // Regular padding for layout
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier
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
        ) {
            Spacer(modifier = Modifier.height(138.dp))
            Text(
                text = "Sign Up",
                fontFamily = Montserrat,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(76.dp))
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            inputFields(
                name = "Username",
                inputState = userNameState,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(
                name = "Email / Phone",
                inputState = emailState,
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(12.dp))
                Column{Text(text = "Password" , fontFamily = Montserrat , fontSize = 16.sp , fontWeight = FontWeight.Medium , color = Color(
                    0xFF757575
                )
                )
                Spacer(modifier = Modifier.height(12.dp))
                TextField(modifier = Modifier
                    .height(50.dp)
                    .width(300.dp)
                    .border(1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)), value = passwordState.value , onValueChange = {passwordState.value = it},shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password ,imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions.Default,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(
                            onClick = { isPasswordVisible = !isPasswordVisible }
                        ) {
                            val painter = if (isPasswordVisible) painterResource(id = R.drawable.eye) else painterResource(id = R.drawable.invisible)
                            Icon(
                                painter = painter,
                                contentDescription = "Toggle Password Visibility",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )
                }
            Spacer(modifier = Modifier.height(12.dp))
            inputFields(
                name = "Confirm Password",
                inputState = confirmPasswordState,
                keyboardType = KeyboardType.Password
            )
            Spacer(modifier = Modifier.height(34.dp))
            MainButton(title = "Sign Up", onClick = {
                if (valid && passwordState.value == confirmPasswordState.value) {
                    viewModel.createUserWithEmailandPassword(emailState.value , passwordState.value , userNameState.value ){
                        navController.navigate(MenooScreens.HomeScreen.name)
                    }
                    Toast.makeText(context, "Signed in successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate(MenooScreens.HomeScreen.name)
                } else {
                    Toast.makeText(context, "Enter all the credentials", Toast.LENGTH_SHORT).show()
                }
            })
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Already have an account?",
                    fontFamily = Montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Login",
                    fontFamily = Montserrat,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.clickable { navController.navigate(MenooScreens.LoginScreen.name) }
                )
            }
        }
        }
    }
}