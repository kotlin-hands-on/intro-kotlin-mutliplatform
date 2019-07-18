package com.jetbrains.handson.introMpp

import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlin.browser.document

const val jvmBackend = "http://$jvmHost:$jvmPort"

fun main() {
  document.getElementById("app")
          ?.also { it.innerHTML = "" }
          ?.append {
            h1 { +"Kotlin Fractals" }
            h2 { +"JS Edition" }
            img(src = "$jvmBackend/mandelbrot")
          }
}
