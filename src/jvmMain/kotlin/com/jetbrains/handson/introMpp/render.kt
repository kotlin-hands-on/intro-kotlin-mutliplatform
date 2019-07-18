package com.jetbrains.handson.introMpp

import java.awt.Color

interface FractalImage {
  val pixelRect: Rect<Int>
  fun putPixel(p: Pixel, c: Color)
}

object MandelbrotRender {
  val initialArea = Rect(-2.0, -2.0, 2.0, 2.0)

  fun justRender(maxIterations: Int = 1500,
                 image: FractalImage,
                 area: Rect<Double>) {

    Transformation(pixelRect = image.pixelRect, fractalRect = area).forEachPixel { p, c ->
      var z = Complex.ZERO
      var iterations = 0

      // performs the building of the fractal.
      // see https://en.wikipedia.org/wiki/Mandelbrot_set
      val color = run {
        repeat(maxIterations) {
          z = z * z + c
          iterations++
          if (z.mod2 > 4) {
            //stops repeat{} function and return the color from run{}
            return@run pickColor(z, iterations)
          }
        }
        Color.BLACK
      }

      image.putPixel(p, color)
    }
  }
}

