package com.quid.gateway.dummy

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dummy")
class DummyController {

    @GetMapping("/timeout")
    fun fallback() {
        println("DummyController: timeout")
        Thread.sleep(10000)
        println("DummyController: timeout done")
    }

}