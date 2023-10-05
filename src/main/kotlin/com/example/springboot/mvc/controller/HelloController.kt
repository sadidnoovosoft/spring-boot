package com.example.springboot.mvc.controller

import com.example.springboot.mvc.model.Response
import com.example.springboot.mvc.model.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String = "Hello World!"

    @GetMapping("/hello1")
    fun hello1(@RequestParam name: String): String {
        return "Hello $name"
    }

    @GetMapping("/hello2/{name}")
    fun hello2(@PathVariable name: String): String {
        return "Hello $name"
    }

    @PostMapping("/hello3")
    @ResponseStatus(HttpStatus.OK)
    fun hello3(@RequestBody user: User): Response {
        return Response("Hello ${user.name}")
    }

    @GetMapping("/hello4")
    fun hello4(@RequestHeader("Accept-Language", defaultValue = "hin") acceptLanguage: String): String {
        println(acceptLanguage)
        return when (acceptLanguage) {
            "hin" -> "Namaste"
            "en" -> "Hello"
            else -> "Unknown"
        }
    }
}