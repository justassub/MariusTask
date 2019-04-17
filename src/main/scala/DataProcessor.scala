import util.{FileReader, FileWriter}

class DataProcessor(path: String, maxSize: Int) {
  def calcuteAndSaveResult() = {
    val stringToProcess = FileReader.readResource(path)
    val processedString = TextWrapper.wrapText(stringToProcess, maxSize)
    FileWriter.writeOutput(processedString.mkString("\n"));
  }
}
