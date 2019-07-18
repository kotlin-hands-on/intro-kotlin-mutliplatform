package com.jetbrains.handson.introMpp

import kotlinx.html.dom.append
import kotlinx.html.js.h1
import kotlinx.html.js.h2
import kotlinx.html.js.img
import kotlin.browser.document

const val jvmBackend = "http://127.0.0.1:8888"

fun main() {
  document.getElementById("app")
          ?.also { it.innerHTML = "" }
          ?.append {
            h1 { +"Kotlin Fractals" }
            h2 { +"JS Edition" }
            img(src = "$jvmBackend/mandelbrot")
          }
}
