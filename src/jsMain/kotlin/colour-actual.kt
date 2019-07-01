package com.jetbrains.handson.introMpp

actual class Color(
        val r: Int,
        val g: Int,
        val b: Int
)

actual fun Colors.newColor(r: Int, g: Int, b: Int) = Color(r, g, b)
actual val Colors.BLACK: Color get() = Color(0, 0, 0)
