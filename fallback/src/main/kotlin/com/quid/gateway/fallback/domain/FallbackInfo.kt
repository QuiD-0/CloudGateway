package com.quid.gateway.fallback.domain

data class FallbackInfo(
    private val userAgent: String,
    private val xRequestServer: String,
    private val executionExceptionType: String,
    private val executionExceptionMessage: String,
    private val rootCauseExceptionType: String,
    private val rootCauseExceptionMessage: String,
    private val forwarded: String,
    private val xForwardedFor: String,
    private val xForwardedHost: String,
)

fun toFallbackInfo(headers: Map<String?, String?>): FallbackInfo = FallbackInfo(
    userAgent = headers["User-Agent"] ?: "",
    xRequestServer = headers["X-Request-Server"] ?: "",
    executionExceptionType = headers["Execution-Exception-Type"] ?: "",
    executionExceptionMessage = headers["Execution-Exception-Message"] ?: "",
    rootCauseExceptionType = headers["Root-Cause-Exception-Type"] ?: "",
    rootCauseExceptionMessage = headers["Root-Cause-Exception-Message"] ?: "",
    forwarded = headers["Forwarded"] ?: "",
    xForwardedFor = headers["X-Forwarded-For"] ?: "",
    xForwardedHost = headers["X-Forwarded-Host"] ?: "",
)
