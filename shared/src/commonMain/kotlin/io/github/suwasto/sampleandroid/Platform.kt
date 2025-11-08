package io.github.suwasto.sampleandroid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform