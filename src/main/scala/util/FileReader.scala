package util

import scala.io.Source

object FileReader {
  def readResource(implicit path: String): Stream[String] =
    Source.fromFile(path).getLines().toStream
}
