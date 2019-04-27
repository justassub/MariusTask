package util

import scala.io.Source

object FileReader {
  def readResource(implicit path: String): Iterator[String] =
    Source.fromFile(path).getLines()
}
