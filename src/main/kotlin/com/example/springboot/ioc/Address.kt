package com.example.springboot.ioc

data class Address(val street: String, val city: String) {
    override fun toString(): String {
        return "Address(street='$street', city='$city')"
    }
}