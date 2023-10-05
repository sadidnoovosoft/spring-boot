package com.example.springboot.mvc.controller

import com.example.springboot.mvc.model.Data
import com.example.springboot.mvc.model.LoginForm
import com.example.springboot.mvc.model.Response
import com.example.springboot.mvc.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController {

    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleException(e: NoSuchElementException): ResponseEntity<Response> {
        return ResponseEntity(Response(e.message ?: "No such element found."), HttpStatus.NOT_FOUND)
    }

    @PostMapping("/login")
    fun login(@RequestBody data: LoginForm): Response {
        println(data)
        return Response("Login Successful!!")
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok()
            .header("Custom-Header", "customHeader")
            .body(Data.users)
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> {
        val user = Data.users.first { it.id == id }
        return ResponseEntity(user, HttpStatus.OK)
    }
}