package com.quid.gateway.filter

data class Packets(
    val message: String,
    val preLogger: Boolean,
    val postLogger: Boolean,
)