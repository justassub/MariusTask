package util

import java.io.InputStreamReader

import scala.io.Source

object FileReader {

  def readResource(implicit path: String): Stream[String] = {
    val bis = Source.fromFile(path).reader(): InputStreamReader
    val readBytes = 1023

    def read(stream: Stream[String] = Stream.empty, startBytes: Int = 0): Stream[String] = {
      val chars = Array.fill[Char](readBytes)(0)
      val bytes = bis.read(chars)
      if (bytes == readBytes) {
        read(stream ++ Stream(chars.mkString), startBytes + readBytes)
      } else {
        stream ++ Stream(chars.take(bytes).mkString)
      }
    }

    read()

  }

}
