package util

object FileWriter {
  private val output = "target/test/output/file.txt"

  def writeOutput(outputResult: String) = reflect.io.File(output).writeAll(outputResult)
}
