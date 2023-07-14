package com.quid.circuitBreaker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dummy")
class DummyController {

    @GetMapping("/timeout")
    fun dummy() {
        println("DummyController: timeout")
        Thread.sleep(10000)
        println("DummyController: timeout done")
    }

    @GetMapping("/error")
    fun error() {
        println("DummyController: error")
        throw RuntimeException("DummyController: error")
    }
}