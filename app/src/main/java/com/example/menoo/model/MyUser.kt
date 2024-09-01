package com.example.menoo.model

import com.google.firebase.firestore.QueryDocumentSnapshot

data class MyUser(
    val userName : String,
    val userId : String,
){
    fun toMap(): MutableMap<String , Any> {
        return mutableMapOf(
            "userName" to this.userName,
            "userId" to this.userId
        )
    }
}