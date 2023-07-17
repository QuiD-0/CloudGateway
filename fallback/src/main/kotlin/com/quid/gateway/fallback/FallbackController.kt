package com.quid.gateway.fallback

import com.quid.gateway.fallback.domain.toFallbackInfo
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fallback")
class FallbackController {

    private val logger = LoggerFactory.getLogger(FallbackController::class.java)

    @GetMapping
    fun fallback(
        @RequestHeader headers: Map<String?, String?>,
    ) {
        logger.info("Fallback income")
        logger.info("Headers: $headers")
        toFallbackInfo(headers)
            .also { logger.info(it.toString()) }
    }
}

