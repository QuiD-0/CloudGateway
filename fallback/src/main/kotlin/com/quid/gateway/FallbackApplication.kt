package com.quid.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FallbackApplication

fun main(args: Array<String>) {
	runApplication<FallbackApplication>(*args)
}
