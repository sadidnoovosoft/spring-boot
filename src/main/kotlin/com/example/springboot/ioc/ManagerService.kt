package com.example.springboot.ioc

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class ManagerService(@Qualifier("generalManager") private val manager: Manager) {
    fun getDesignation(): String {
        return manager.designation()
    }
}