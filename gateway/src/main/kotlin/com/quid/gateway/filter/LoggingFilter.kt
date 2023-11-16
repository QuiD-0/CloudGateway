package com.quid.gateway.filter

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class LoggingFilter : AbstractGatewayFilterFactory<Packets>(Packets::class.java) {
    private val log = LoggerFactory.getLogger(LoggingFilter::class.java)

    override fun apply(data: Packets): GatewayFilter =
        GatewayFilter { exchange, chain ->
            val request = exchange.request
            val response = exchange.response

            if (data.preLogger) {
                log.info(
                    "[GATEWAY] target : {} , address : {}",
                    data.message,
                    request.remoteAddress
                )
            }

            chain.filter(exchange).then(Mono.fromRunnable {
                if (data.postLogger) {
                    log.info("Response status : {}", response.statusCode)
                }
            })
        }
}