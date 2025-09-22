package com.yoesuv.kmptask

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform