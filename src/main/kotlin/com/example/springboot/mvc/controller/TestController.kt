package com.example.springboot.mvc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @RequestMapping(value = ["/ex/value"], method = [RequestMethod.GET])
    fun getSomeValue(): String {
        return "Get some value"
    }

    @RequestMapping(value = ["/ex/value"], method = [RequestMethod.POST])
    fun postSomeValue(): String {
        return "Post some value"
    }

    @RequestMapping(value = ["/ex/value"], headers = ["key=val"], method = [RequestMethod.GET])
    fun getValueWithHeader(): String {
        return "Get Some Value with Header"
    }

    @RequestMapping(
        value = ["/ex/value"],
        headers = ["key1=val1", "key2=val2"], method = [RequestMethod.GET]
    )
    fun getValueWithHeaders(): String {
        return "Get Some Value with Headers"
    }

    @RequestMapping(value = ["/ex/value/{id}"], method = [RequestMethod.GET])
    fun getValueWithPathVariable(@PathVariable("id") id: Long): String {
        return "Get value with id: $id"
    }

    @RequestMapping(value = ["/ex/value/{fooId}/bar/{barId}"], method = [RequestMethod.GET])
    fun getValueWithPathVariables(@PathVariable fooId: Int, @PathVariable barId: Int): String {
        return "Get value with fooId: $fooId and barId: $barId"
    }

    @GetMapping(value = ["/ex/value"], params = ["id"])
    fun getValueWithReqParams(@RequestParam id: Long, @RequestParam name: String): String {
        println("$id $name")
        return "Get value with id: $id and name: $name"
    }

    @GetMapping("/ex/value/page")
    fun getValuePage(@RequestParam params: Map<String, String>): Map<String, String> {
        return params.mapValues { it.value.uppercase().reversed() }
    }

    @RequestMapping("*")
    fun fallBack(): String {
        return "Fallback for All Unhandled Requests"
    }
}