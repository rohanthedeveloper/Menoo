package com.example.menoo.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.menoo.ui.theme.Montserrat

//@Preview
@Composable
fun inputFields(
    name : String = "Password",
    modifier: Modifier = Modifier,
    inputState : MutableState<String>  ,
    imeAction: ImeAction = ImeAction.Next ,
    onAction : KeyboardActions = KeyboardActions.Default,
    isSingleLine : Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
){
    Column {
        Text(text = name , fontFamily = Montserrat , fontSize = 16.sp , fontWeight = FontWeight.Medium , color = Color(
            0xFF757575
        )
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            modifier = Modifier
                .height(50.dp)
                .width(300.dp)
                .border(1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
            value = inputState.value,
            onValueChange = {inputState.value = it},
            shape = RoundedCornerShape(8.dp),
            singleLine = isSingleLine,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType ,imeAction = imeAction),
            keyboardActions = onAction,

        )
    }
}


@Composable
fun MainButton(title : String, modifier: Modifier = Modifier , onClick : () -> Unit ) {
    Button(onClick = onClick , shape = RoundedCornerShape(8.dp) , colors = ButtonDefaults.buttonColors(Color(
        0xFF4CAF50
    ),
    ), modifier = Modifier
        .height(50.dp)
        .width(300.dp)) {
        Text(
            text = title ,
            fontFamily = Montserrat ,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
