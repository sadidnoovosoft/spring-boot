package com.example.springboot.ioc

import org.springframework.stereotype.Component

@Component("generalManager")
class GeneralManager : Manager {
    override fun designation(): String {
        return "General Manager!"
    }
}