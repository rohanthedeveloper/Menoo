package com.example.menoo.screens.SignUpScreen

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.menoo.model.MyUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore

class SignUpScreenViewModel : ViewModel(){
    private val _loading = MutableLiveData(false)
    val loading : LiveData<Boolean> = _loading

    private val auth : FirebaseAuth = Firebase.auth



    fun createUserWithEmailandPassword(
        email : String ,
        password : String,
        username : String,
        home : () -> Unit
    ) {
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email , password ).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    createUser(username)
                    home()
                }
            }
            _loading.value = false
        }
    }

    private fun createUser(username : String) {
        val userId = auth.currentUser?.uid
        val user = MyUser(
            userId = userId!!,
            userName = username
        ).toMap()
        FirebaseFirestore
            .getInstance()
            .collection("users")
            .document(userId)
            .set(user).addOnSuccessListener {  }.addOnFailureListener{ }

    }
}