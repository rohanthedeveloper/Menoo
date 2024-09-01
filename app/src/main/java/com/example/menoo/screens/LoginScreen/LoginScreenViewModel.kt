package com.example.menoo.screens.LoginScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import kotlinx.coroutines.launch

class LoginScreenViewModel() : ViewModel(){
    private val auth : FirebaseAuth = Firebase.auth

    fun loginUserWithEmailandPassword(
        email : String,
        password : String,
        home : () -> Unit
    ) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email , password).addOnCompleteListener{
                task ->
                if (task.isSuccessful){
                    home()
                }
            }
        }catch (e : Exception){
            Log.d("EXC", "signInWithEmailAndPassword: ${e.message}")
        }
    }
}

