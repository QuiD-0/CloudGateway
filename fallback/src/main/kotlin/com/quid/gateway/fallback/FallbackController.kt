package com.quid.gateway.fallback

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fallback")
class FallbackController {

    @GetMapping
    fun fallback(
        @RequestHeader headers: Map<String?, String?>,
    ) {
        println("Fallback income")
        println("Headers: $headers")
    }

}