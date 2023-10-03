package com.example.springboot.ioc

import org.springframework.stereotype.Component

@Component("regionalManager")
class RegionalManager : Manager {
    override fun designation(): String {
        return "Regional Manager"
    }
}