package com.jetbrains.handson.introMpp


import io.ktor.http.ContentType
import io.ktor.http.content.OutgoingContent
import kotlinx.coroutines.io.ByteWriteChannel
import kotlinx.coroutines.io.jvm.javaio.toOutputStream
import java.awt.Color
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class FractalGraphics(val g: BufferedImage) : FractalImage {
  override val pixelRect
    get() = Rect(0, 0, g.width, g.height)

  override fun putPixel(p: Pixel, c: Color) {
    g.setRGB(p.x, p.y, c.rgb)
  }
}

fun BufferedImage.toMessage() = object : OutgoingContent.WriteChannelContent() {
  override val contentType = ContentType.Image.PNG

  override suspend fun writeTo(channel: ByteWriteChannel) {
    channel.toOutputStream().use {
      ImageIO.write(this@toMessage, "png", it)
    }
  }
}
