package com.example.springboothelloworld

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorldController() {

    @GetMapping("/{name}")
    fun greet(@PathVariable(value = "name") name: String) = ResponseEntity("Hello, {name}", HttpStatus.OK)
}
