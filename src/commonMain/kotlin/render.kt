package com.jetbrains.handson.introMpp


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

      val color = run {
        repeat(maxIterations) {
          z = z * z + c
          iterations++
          if (z.mod2 > 4) {
            //stop repeat{} function and return the color from run{}
            return@run pickColor(z, iterations)
          }
        }
        Colors.BLACK
      }

      image.putPixel(p, color)
    }
  }
}

