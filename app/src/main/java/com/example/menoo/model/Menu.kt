package com.example.menoo.model

 data class Menu (
     val item1 : String ,
     val item2 : String,
 )

val menuList = listOf<Menu>(
    Menu("Palak Paneer" , "Aloo Palak")
)

data class Mess(
    val name : String,
    val item1: String,
    val item2: String
)

val messList = listOf(
    Mess("Maheshwari mess" , "Palak Paneer" , "Shevbhaji"),
    Mess("Maheshwari mess" , "Palak Paneer" , "Shevbhaji"),
    Mess("Maheshwari mess" , "Palak Paneer" , "Shevbhaji"),
    Mess("Maheshwari mess" , "Palak Paneer" , "Shevbhaji"),
    Mess("Maheshwari mess" , "Palak Paneer" , "Shevbhaji"),


)