package util

import scala.io.Source

object FileReader {
  def readResource(implicit path: String): String =
    Source.fromFile(path).getLines().mkString("\n")
}
