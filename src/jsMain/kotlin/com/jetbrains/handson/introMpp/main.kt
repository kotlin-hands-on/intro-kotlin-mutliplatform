package com.jetbrains.handson.introMpp

import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.js.canvas
import kotlinx.html.js.h1
import kotlinx.html.js.h2
import kotlinx.html.js.img
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document

const val jvmBackend = "http://$jvmHost:$jvmPort"

fun main() {
  document.getElementById("app")
          ?.also { it.innerHTML = "" }
          ?.append {
            h1 { +"Kotlin Fractals" }
            h2 { +"JS Edition" }
            img(src = "$jvmBackend/mandelbrot")
            canvas {
              id = "canvas"
              width = "600"
              height = "600"
            }
          }

  renderToCanvas(document.getElementById("canvas") as HTMLCanvasElement) { image ->
    MandelbrotRender.justRender(300, image, MandelbrotRender.initialArea)
  }
}
