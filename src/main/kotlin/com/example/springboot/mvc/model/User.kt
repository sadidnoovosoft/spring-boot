package com.example.springboot.mvc.model

data class User(val id: Int, val name: String, val age: Int, val email: String)

object Data {
    val users = listOf(
        User(
            id = 1,
            name = "Sadid Shaikh",
            age = 20,
            email = "sadid.shiakh@noovosoft.com"
        ),
        User(
            id = 2,
            name = "Tejas Ekhande",
            age = 21,
            email = "tejas.ekhande@noovosoft.com"
        )
    )
}