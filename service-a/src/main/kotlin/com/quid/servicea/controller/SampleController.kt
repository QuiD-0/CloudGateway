package com.quid.servicea.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sample")
class SampleController {
    private val logger = LoggerFactory.getLogger(SampleController::class.java)

    @GetMapping("/hello")
    fun hello(): String {
        logger.info("request received")
        return "Hello from Service A"
    }
    
}