package com.example.springboot.ioc

import org.springframework.stereotype.Component

@Component
class Company(val address: Address) {
    override fun toString(): String {
        return "Company(address=$address)"
    }
}
