package com.example.springboot.ioc

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)

    val service: ManagerService = context.getBean(ManagerService::class.java)
    println(service.getDesignation())
}