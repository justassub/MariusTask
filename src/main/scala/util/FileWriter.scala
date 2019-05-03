package util

import scala.util.Properties

object FileWriter {
  private val output = "target/test/output/file.txt"

  def writeOutput(outputResult: Stream[String]) = {
    import java.io._

    val writer = new BufferedWriter(new FileWriter(output))
    outputResult.foreach(line => writer.write(line + Properties.lineSeparator))
    writer.close()
  }

  def writeOutput(outputResult: String) = reflect.io.File(output).writeAll(outputResult)
}
