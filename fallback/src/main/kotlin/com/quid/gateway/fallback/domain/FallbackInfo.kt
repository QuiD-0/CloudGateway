package com.quid.gateway.fallback.domain

class FallbackInfo(
    private val userAgent: String = "",
    private val acceptEncoding: String = "",
    private val executionExceptionType: String = "",
    private val executionExceptionMessage: String = "",
    private val rootCauseExceptionType: String = "",
    private val rootCauseExceptionMessage: String = "",
    private val xRequestServer: String = "",
    private val forwarded: String = "",
    private val xForwardedFor: String = "",
    private val xForwardedPort: String = "",
) {
    override fun toString(): String = "FallbackInfo(UserAgent='$userAgent', " +
            "AcceptEncoding='$acceptEncoding', " +
            "ExecutionExceptionType='$executionExceptionType', " +
            "ExecutionExceptionMessage='$executionExceptionMessage', " +
            "RootCauseExceptionType='$rootCauseExceptionType', " +
            "RootCauseExceptionMessage='$rootCauseExceptionMessage', " +
            "XRequestServer='$xRequestServer', " +
            "Forwarded='$forwarded'," +
            "XForwardedFor='$xForwardedFor', " +
            "XForwardedPort='$xForwardedPort')"
}

fun toFallbackInfo(headers: Map<String?, String?>): FallbackInfo = FallbackInfo(
    userAgent = headers["User-Agent"] ?: "",
    acceptEncoding = headers["Accept-Encoding"] ?: "",
    executionExceptionType = headers["Execution-Exception-Type"] ?: "",
    executionExceptionMessage = headers["Execution-Exception-Message"] ?: "",
    rootCauseExceptionType = headers["Root-Cause-Exception-Type"] ?: "",
    rootCauseExceptionMessage = headers["Root-Cause-Exception-Message"] ?: "",
    xRequestServer = headers["X-Request-Server"] ?: "",
    forwarded = headers["Forwarded"] ?: "",
    xForwardedFor = headers["X-Forwarded-For"] ?: "",
    xForwardedPort = headers["X-Forwarded-Port"] ?: "",
)
